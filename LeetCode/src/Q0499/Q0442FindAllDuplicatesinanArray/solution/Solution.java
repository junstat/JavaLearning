package Q0499.Q0442FindAllDuplicatesinanArray.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            if (t < 0 || t - 1 == i) continue;
            if (nums[t - 1] == t) {
                ans.add(t);
                nums[i] *= -1;
            } else {
                int c = nums[t - 1];
                nums[t - 1] = t;
                nums[i--] = c;
            }
        }
        return ans;
    }
}