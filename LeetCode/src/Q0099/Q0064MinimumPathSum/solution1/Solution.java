package Q0099.Q0064MinimumPathSum.solution1;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 处理边界
                if (i == 0 && j > 0) f[i][j] = f[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0) f[i][j] = f[i - 1][j] + grid[i][j];
                else if (i > 0) f[i][j] = Math.min(f[i][j - 1], f[i - 1][j]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}