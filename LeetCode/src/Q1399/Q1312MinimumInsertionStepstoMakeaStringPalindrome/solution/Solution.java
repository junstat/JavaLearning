package Q1399.Q1312MinimumInsertionStepstoMakeaStringPalindrome.solution;

public class Solution {
    public int minInsertions(String ss) {
        char[] s = ss.toCharArray();
        var n = s.length;
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i + 1][j + 1] = s[i] == s[n - 1 - j] ? f[i][j] + 1 :
                        Math.max(f[i][j + 1], f[i + 1][j]);
            }
        }
        return n - f[n][n];
    }
}
