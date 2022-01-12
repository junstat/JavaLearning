package Q0099.Q0010RegularExpressionMatching;

/*
 We define dp[i][j] to be true if s[0...i) matches p[0..j) and false otherwise. The state equations will be:
 1. dp[i][j] = dp[i-1][j-1], if p[j-1] != '*' && (s[i-1] == p[j-1] || p[j-1] == '.')
 2. dp[i][j] = d[i][j-2], if p[j-1] == '*' and the pattern repeats for 0 time.
 3. dp[i][j] = dp[i-1][j] && (s[i-1] == p[j-2] || p[j-2] == '.'),
    if p[j-1] == '*' and the pattern repeats for at least 1 time.
 */
public class Solution2 {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (
                            i > 0 && dp[i - 1][j] &&
                                    (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                    );
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] &&
                            (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }
        return dp[m][n];
    }
}