package Q1899.Q1814CountNicePairsinanArray.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int mod = (int) 1e9 + 7;

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            int rev = 0;
            for (int t = x; t != 0; t /= 10) rev = rev * 10 + t % 10;
            ans = (ans + mp.getOrDefault(x - rev, 0)) % mod;
            mp.put(x - rev, mp.getOrDefault(x - rev, 0) + 1);
        }
        return ans;
    }
}