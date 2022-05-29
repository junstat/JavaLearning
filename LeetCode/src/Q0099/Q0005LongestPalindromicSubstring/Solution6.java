package Q0099.Q0005LongestPalindromicSubstring;

public class Solution6 {
    public String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++)
            ret.append("#").append(s.charAt(i));
        ret.append("#$");
        return ret.toString();
    }

    public String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int C = 0, R = 0;
        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * C - i;
            if (i < R) {
                P[i] = Math.min(R - i, P[iMirror]);  // 做越界限定
            } else { // i >= R
                P[i] = 0;   // 等于R的情况
            }

            // 碰到之前的三种情况，需要利用中心扩展法
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i]))
                P[i]++;

            // 判断是否需要更新R
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // 找出P的最大值
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int start = (centerIndex - maxLen) / 2;     // 最开始讲的求原字符串下标
        return s.substring(start, start + maxLen);
    }
}
