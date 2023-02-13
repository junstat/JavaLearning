package Q1299.Q1223DiceRollSimulation.solution;

import java.util.Arrays;

public class Solution {
    static final int MOD = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        long[][] dp = new long[n + 1][7];
        for (int i = 1; i <= 6; i++) dp[1][i] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                // 加入第i-1次得所有可能序列总数
                long ans = Arrays.stream(dp[i - 1]).sum();
                int idx = i - 1 - rollMax[j - 1];
                if (idx >= 1) {
                    // 减去i-1-rollMax[j-1]次掷出1,2,3,4,5的所有序列总数
                    ans = accumulate(dp[idx], ans);
                    ans += dp[idx][j];
                } else if (idx == 0) {
                    // 特殊情况处理
                    ans -= 1;
                }
                dp[i][j] = ans % MOD;
            }
        }
        return (int) (Arrays.stream(dp[n]).sum() % MOD);
    }

    long accumulate(long[] nums, long init) {
        long ans = init;
        for (long num : nums) ans += (MOD - num);
        return ans;
    }
}
