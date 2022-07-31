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
            p[i] = i < r ? Math.min(r - i, p[iM]) : 0; // 左边界越界限定
            while (ts[i + 1 + p[i]] == ts[i - 1 - p[i]]) p[i]++;
            // 判断是否更新R
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
        StringBuilder res = new StringBuilder("^");
        for (int i = 0; i < n; i++) res.append('#').append(cs[i]);
        res.append("#$");
        return res.toString();
    }
}