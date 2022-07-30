package Q0799.Q0712MinimumASCIIDeleteSumforTwoStrings.solution4;

import java.util.Arrays;

public class Solution {
    static int INF = (int) 1e9;

    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() > s2.length()) return minimumDeleteSum(s2, s1);
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        for (int i = 0; i <= m; i++) {
            int pre = 0;
            for (int j = 0; j <= n; j++) {
                int cur = dp[j];
                if (i == 0 && j == 0) dp[j] = 0;
                else if (i > 0 && j > 0 && cs1[i - 1] == cs2[j - 1]) dp[j] = pre;
                else dp[j] = Math.min(i > 0 ? dp[j] + cs1[i - 1] : INF, j > 0 ? dp[j - 1] + cs2[j - 1] : INF);
                pre = cur;
            }
        }
        return dp[n];
    }
}
