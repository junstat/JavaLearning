package Q0499.Q0446ArithmeticSlicesIISubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int n = nums.length;
        int[][] len = new int[n][n];

        Map<Long, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Integer> lst = map.get(nums[i] - (nums[j] - (long) nums[i]));

                if (lst == null) continue;
                for (int num : lst)
                    len[i][j] += len[num][i] + 1;
                res += len[i][j];
            }
            map.computeIfAbsent((long) nums[i], k -> new ArrayList<>()).add(i);
        }
        return res;
    }
}
