package Q0599.Q0560SubarraySumEqualsK.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;
        int[] sum = new int[n + 10];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int t = sum[i], d = t - k;
            ans += map.getOrDefault(d, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;
    }
}