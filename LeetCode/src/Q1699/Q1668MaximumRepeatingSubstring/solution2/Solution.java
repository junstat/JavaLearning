package Q1699.Q1668MaximumRepeatingSubstring.solution2;

public class Solution {
    long[] h, p;

    public int maxRepeating(String ss, String pp) {
        int n = ss.length(), m = pp.length(), ans = 0;
        int[] f = new int[n + 10];

        String s = ss + pp;
        int P = 1313131, N = s.length();
        h = new long[N + 10];
        p = new long[N + 10];
        p[0] = 1;
        for (int i = 1; i <= N; i++) {
            h[i] = h[i - 1] * P + s.charAt(i - 1);
            p[i] = p[i - 1] * P;
        }
        long phash = h[N] - h[N - m] * p[m];

        for (int i = 1; i <= n; i++) {
            if (i - m < 0) continue;
            long cur = h[i] - h[i - m] * p[m];
            if (cur == phash) f[i] = f[i - m] + 1;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}