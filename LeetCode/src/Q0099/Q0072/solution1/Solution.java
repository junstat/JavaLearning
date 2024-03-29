package Q0099.Q0072.solution1;

public class Solution {
    public int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) f[i][0] = i;
        for (int i = 1; i <= n; i++) f[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cs1[i - 1] == cs2[j - 1]) f[i][j] = f[i - 1][j - 1];
                else f[i][j] = Math.min(f[i - 1][j - 1], Math.min(f[i - 1][j], f[i][j - 1])) + 1;
            }
        }
        return f[m][n];
    }
}