package Q1299.Q1254NumberofClosedIslands.solution;

public class Solution {
    int[][] g;
    int m, n;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int closedIsland(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) ans += dfs(i, j) ? 1 : 0;
            }
        }
        return ans;
    }

    boolean dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return false;
        if (g[i][j] == 1) return true;
        g[i][j] = 1;

        boolean ans = true;
        for (int[] dir : dirs) ans &= dfs(i + dir[0], j + dir[1]);

        return ans;
    }
}
