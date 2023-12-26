package Q0099.Q0005.solution1;

public class Solution {

    public String longestPalindrome(String s) {
        String result = "";
        int maxLen = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String cur = s.substring(i, j);  // s[i, j), 故上面的j要取到等号
                if (isPalindromic(cur) && cur.length() > maxLen) {
                    result = cur;
                    maxLen = Math.max(maxLen, result.length());
                }
            }
        }
        return result;
    }

    private boolean isPalindromic(String s) {
        int n = s.length();
        for (int start = 0, end = n - 1; start < end; start++, end--)
            if (s.charAt(start) != s.charAt(end)) return false;
        return true;
    }
}