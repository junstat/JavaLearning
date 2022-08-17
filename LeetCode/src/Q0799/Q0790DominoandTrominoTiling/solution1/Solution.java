package Q0799.Q0790DominoandTrominoTiling.solution1;

public class Solution {
    public int numTilings(int n) {
        long mod = (int) 1e9 + 7;
        long[][] dp = new long[n + 2][n + 2];
        dp[1][1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            dp[i][i] = (dp[i - 1][i - 1] + dp[i - 1][i - 2] * 2 + dp[i - 2][i - 2]) % mod;
            dp[i][i - 1] = (dp[i - 1][i - 2] + dp[i - 2][i - 2]) % mod;
        }
        return (int) dp[n + 1][n + 1];
    }
}
