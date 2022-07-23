package Q0599.Q0594LongestHarmoniousSubsequence.solution2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) map.put(i, map.getOrDefault(i, 0) + 1);
        int ans = 0;
        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                ans = Math.max(ans, map.get(i) + map.get(i - 1));
            }
        }
        return ans;
    }
}