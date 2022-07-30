package Q0799.Q0712MinimumASCIIDeleteSumforTwoStrings.solution3;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.length() > s2.length()) return minimumDeleteSum(s2, s1);
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int m = cs1.length, n = cs2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) dp[i] = dp[i - 1] + cs2[i - 1];
        for (int i = 1; i <= m; i++) {
            int pre = dp[0];
            dp[0] += cs1[i - 1];
            for (int j = 1; j <= n; j++) {
                int next = dp[j];
                if (cs1[i - 1] == cs2[j - 1]) dp[j] = pre;
                else dp[j] = Math.min(cs1[i - 1] + dp[j], cs2[j - 1] + dp[j - 1]);
                pre = next;
            }
        }
        return dp[n];
    }
}