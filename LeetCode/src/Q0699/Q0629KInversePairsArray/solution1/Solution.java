package Q0699.Q0629KInversePairsArray.solution1;

import java.util.Arrays;

public class Solution {
    int mod = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        long[][] f = new long[n + 1][k + 1];
        long[][] sum = new long[n + 1][k + 1];
        f[1][0] = 1;
        Arrays.fill(sum[1], 1);
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                f[i][j] = j < i ? sum[i - 1][j] : sum[i - 1][j] - sum[i - 1][j - (i - 1) - 1];
                f[i][j] = (f[i][j] + mod) % mod;
                sum[i][j] = j == 0 ? f[i][j] : sum[i][j - 1] + f[i][j];
                sum[i][j] = (sum[i][j] + mod) % mod;
            }
        }
        return (int) f[n][k];
    }
}