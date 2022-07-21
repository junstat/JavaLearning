package Q0499.Q0494TargetSum.solution3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }
    Map<String, Integer> cache = new HashMap<>();
    int dfs(int[] nums, int t, int u, int cur) {
        String key = u + "_" + cur;
        if (cache.containsKey(key)) return cache.get(key);
        if (u == nums.length) {
            cache.put(key, cur == t ? 1 : 0);
            return cache.get(key);
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        cache.put(key, left + right);
        return cache.get(key);
    }
}