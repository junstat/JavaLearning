package Q0099.Q0005LongestPalindromicSubstring.solution6;

public class Solution {
    public String longestPalindrome(String s) {
        String t = preProcess(s);
        char[] ts = t.toCharArray();
        int n = ts.length;
        int[] p = new int[n];
        int c = 0, r = 0, len = 1, start = 0;
        for (int i = 1; i < n - 1; i++) {
            int iM = 2 * c - i;
            p[i] = i < r ? Math.min(r - i, p[iM]) : 0;
            while (ts[i + p[i] + 1] == ts[i - p[i] - 1]) p[i]++;
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
            if (p[i] > len) {
                len = p[i];
                start = (i - p[i]) / 2;
            }
        }
        return s.substring(start, start + len);
    }

    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        char[] cs = s.toCharArray();
        StringBuilder ans = new StringBuilder("^");
        for (char c : cs) ans.append('#').append(c);
        ans.append("#$");
        return ans.toString();
    }
}