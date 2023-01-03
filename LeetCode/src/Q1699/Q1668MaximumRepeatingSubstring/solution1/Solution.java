package Q1699.Q1668MaximumRepeatingSubstring.solution1;

public class Solution {
    public int maxRepeating(String ss, String pp) {
        int n = ss.length(), m = pp.length(), ans = 0;
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            String sub = ss.substring(i - m, i);
            if (sub.equals(pp)) f[i] = f[i - m] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}