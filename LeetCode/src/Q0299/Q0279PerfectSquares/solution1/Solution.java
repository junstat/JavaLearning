package Q0299.Q0279PerfectSquares.solution1;

import java.util.Arrays;

/*
    DP
    1) 状态定义: dp[i] 表示 和为i的完全平方数的最少数量
    2) 边界: dp[0] = 0
    3) 状态转移: dp[i] = min{dp[i], dp[i - j*j] + 1}  j in [1, sqrt(i)]

    示例:
    dp[0] = 0
    dp[1] = dp[0] + 1 = 1 <- 1 = 1
    dp[2] = dp[1] + 1 = 2 <- 2 = 1 + 1
    dp[3] = dp[2] + 1 = 3 <- 3 = 1 + 1 + 1
    dp[4] = min{dp[4 - 1*1] + 1, dp[4 - 2 * 2] + 1} = 1 <- 4 = 2 * 2
 */
public class Solution {
    public int numSquares(int n) {
        if (n < 0) return 0;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
