package Q0799.Q0712MinimumASCIIDeleteSumforTwoStrings.solution1;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] + cs1[i - 1];
        for (int i = 1; i <= n; i++) dp[0][i] = dp[0][i - 1] + cs2[i - 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(cs1[i - 1] + dp[i - 1][j], cs2[j - 1] + dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}