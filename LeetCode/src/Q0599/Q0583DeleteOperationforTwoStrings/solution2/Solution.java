package Q0599.Q0583DeleteOperationforTwoStrings.solution2;

public class Solution {
    public int minDistance(String s1, String s2) {
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        int n = s1.length(), m = s2.length();
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) f[i][0] = i;
        for (int j = 0; j <= m; j++) f[0][j] = j;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (cs1[i - 1] == cs2[j - 1]) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
            }
        }
        return f[n][m];
    }
}