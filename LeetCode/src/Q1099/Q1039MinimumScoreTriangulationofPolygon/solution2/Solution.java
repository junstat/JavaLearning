package Q1099.Q1039MinimumScoreTriangulationofPolygon.solution2;

public class Solution {
    public int minScoreTriangulation(int[] v) {
        int n = v.length;
        int[][] f = new int[n][n];
        for (int i = n - 3; i >= 0; --i)
            for (int j = i + 2; j < n; ++j) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k)
                    f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j] + v[i] * v[j] * v[k]);
            }
        return f[0][n - 1];
    }
}