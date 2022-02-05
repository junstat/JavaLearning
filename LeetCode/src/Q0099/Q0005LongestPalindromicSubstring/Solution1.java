package Q0099.Q0005LongestPalindromicSubstring;

/*
    Solution 1: Brute force
    两层循环遍历所有子串，判断是否为回文，保留最长的子串。
 */
public class Solution1 {

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
/*
    time complexity: 两层循环O(n^2)，判断是否回文O(n)，综合为O(n^3)
    space complexity: O(1)

    提交之后，TLE(Time Limit Exceeded)
 */
