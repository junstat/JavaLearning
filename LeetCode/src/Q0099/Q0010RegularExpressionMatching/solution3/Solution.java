package Q0099.Q0010RegularExpressionMatching.solution3;

public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] cur = new boolean[n + 1];
        for (int i = 0; i <= m; i++) {
            boolean pre = cur[0];
            cur[0] = i == 0;
            for (int j = 1; j <= n; j++) {
                boolean temp = cur[j];
                if (p.charAt(j - 1) == '*') {
                    cur[j] = cur[j - 2] ||
                            (i > 0 && cur[j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                } else {
                    cur[j] = i > 0 && pre && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
                pre = temp;
            }
        }
        return cur[n];
    }
}
