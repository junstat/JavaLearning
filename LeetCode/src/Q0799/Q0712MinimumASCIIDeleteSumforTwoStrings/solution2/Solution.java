package Q0799.Q0712MinimumASCIIDeleteSumforTwoStrings.solution2;

import java.util.Arrays;

public class Solution {
    static int INF = (int) 1e9;

    public int minimumDeleteSum(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] line : dp) Arrays.fill(line, INF);
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) dp[i][j] = 0;
                else if (i > 0 && j > 0 && cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(i > 0 ? dp[i - 1][j] + cs1[i - 1] : INF, j > 0 ? dp[i][j - 1] + cs2[j - 1] : INF);
            }
        }
        return dp[m][n];
    }
}