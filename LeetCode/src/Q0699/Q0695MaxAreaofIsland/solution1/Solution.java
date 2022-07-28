package Q0699.Q0695MaxAreaofIsland.solution1;

public class Solution {
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][] grid;
    int m, n;

    public int maxAreaOfIsland(int[][] _grid) {
        grid = _grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    int dfs(int i, int j) {
        grid[i][j] = 0;
        int cnt = 1;
        for (int[] dir : dirs) {
            int dx = dir[0], dy = dir[1];
            int x = i + dx, y = j + dy;
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) continue;
            cnt += dfs(x, y);
        }
        return cnt;
    }
}
