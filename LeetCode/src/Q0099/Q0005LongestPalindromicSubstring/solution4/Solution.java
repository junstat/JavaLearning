package Q0099.Q0005LongestPalindromicSubstring.solution4;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[] dp = new boolean[s.length()];
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) &&
                        ((j - i) < 3 || dp[j - 1]);
                if (dp[j] && j - i + 1 > res.length())
                    res = s.substring(i, j + 1); // [i, j+1)
            }
        }
        return res;
    }
}
