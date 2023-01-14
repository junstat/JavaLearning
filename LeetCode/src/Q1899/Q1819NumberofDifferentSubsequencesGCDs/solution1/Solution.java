package Q1899.Q1819NumberofDifferentSubsequencesGCDs.solution1;

import java.util.Arrays;

public class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int c = Arrays.stream(nums).max().getAsInt();
        int[] g = new int[c + 1];

        for (int x : nums) {
            for (int y = 1; y * y <= x; ++y) {
                if (x % y == 0) {
                    g[y] = g[y] == 0 ? x : gcd(g[y], x);
                    if (y * y != x) {
                        int z = x / y;
                        g[z] = g[z] == 0 ? x : gcd(g[z], x);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= c; i++) {
            if (g[i] == i) ans++;
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
