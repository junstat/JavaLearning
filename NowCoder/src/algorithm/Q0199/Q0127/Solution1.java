package algorithm.Q0199.Q0127;

/*
    DP使用一维数组
 */
public class Solution1 {
    public String LCS(String s1, String s2) {
        int maxLen = 0;
        int end = 0;
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[j + 1] = dp[j] + 1;
                    if (dp[j + 1] > maxLen) {
                        maxLen = dp[j + 1];
                        end = i;
                    }
                } else dp[j + 1] = 0;
            }
        }
        return s1.substring(end - maxLen + 1, end + 1);
    }
}
