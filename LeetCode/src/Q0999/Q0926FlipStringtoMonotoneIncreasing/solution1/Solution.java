package Q0999.Q0926FlipStringtoMonotoneIncreasing.solution1;

import java.util.Arrays;

public class Solution {
    public int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] g = new int[n + 10];
        Arrays.fill(g, n + 10);
        for (int i = 0; i < n; i++) {
            int t = s.charAt(i) - '0';
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (g[mid] > t) r = mid;
                else l = mid + 1;
            }
            g[r] = t;
            ans = Math.max(ans, r);
        }
        return n - ans;
    }
}