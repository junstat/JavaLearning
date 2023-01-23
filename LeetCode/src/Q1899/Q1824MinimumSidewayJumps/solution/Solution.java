package Q1899.Q1824MinimumSidewayJumps.solution;

import java.util.Arrays;

public class Solution {
    static int INF = 0x3f3f3f;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][1] = 0;
        dp[0][0] = 1;
        dp[0][2] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] != 1) dp[i][0] = dp[i - 1][0];
            if (obstacles[i] != 2) dp[i][1] = dp[i - 1][1];
            if (obstacles[i] != 3) dp[i][2] = dp[i - 1][2];
            if (obstacles[i] != 1) dp[i][0] = Math.min(dp[i][0], Math.min(dp[i][1], dp[i][2]) + 1);
            if (obstacles[i] != 2) dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][0], dp[i][2]) + 1);
            if (obstacles[i] != 3) dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][0], dp[i][1]) + 1);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
