package Q0099.Q0005LongestPalindromicSubstring;

public class Solution6 {
    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0, maxLen = Integer.MIN_VALUE, cI = 0;
        for (int i = 1; i < n - 1; i++) {
            int iM = 2 * C - i;
            P[i] = i < R ? Math.min(R - i, P[iM]) : 0; // 左边界越界限定
            // 遇到3种情况，需要利用中心扩展
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) P[i]++;
            // 判断是否更新R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
            if (P[i] > maxLen) {
                maxLen = P[i];
                cI = i;
            }
        }
        int start = (cI - maxLen) / 2; // 求原始字符串下标
        return s.substring(start, start + maxLen);
    }

    String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        StringBuilder res = new StringBuilder("^");
        for (int i = 0; i < n; i++) res.append('#').append(s.charAt(i));
        res.append("#$");
        return res.toString();
    }
}