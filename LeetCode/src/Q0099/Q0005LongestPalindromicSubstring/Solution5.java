package Q0099.Q0005LongestPalindromicSubstring;

public class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return null;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = Math.max(expandAroundCenter(s, i, i),  // 以i为中心扩展
                    expandAroundCenter(s, i, i + 1)); // 以i后面的间隔为中心扩展
            if (n > end - start) {
                start = i - (n - 1) / 2;
                end = i + n / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left, r = right;
        while (l >= 0 && r < s.length() &&
                s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
