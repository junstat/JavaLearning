package Q0099.Q0005LongestPalindromicSubstring;

public class Solution2 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[] dp = new int[n + 1];
        int maxLen = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (s.charAt(i) == rev.charAt(j)) {
                    dp[j + 1] = dp[j] + 1;
                    if (dp[j + 1] > maxLen) {
                        int idxInSource = n - 1 - j;    // dp推导出的顺读起点
                        // dp导出的顺读终点                  实际顺读终点
                        if (idxInSource + dp[j + 1] - 1 == i) {
                            maxLen = dp[j + 1];
                            end = i;
                        }
                    }
                } else dp[j + 1] = 0;
            }
        }
        return s.substring(end - maxLen + 1, end + 1);
    }
}
/*
    time complexity: O(n^2)
    space complexity: O(n)
 */
