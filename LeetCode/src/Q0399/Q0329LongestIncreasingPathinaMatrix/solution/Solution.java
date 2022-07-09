package Q0399.Q0329LongestIncreasingPathinaMatrix.solution;

/*
    To get max length of increasing sequences:
        a.) Do DFS from every cell
        b.) Compare every 4 direction and skip cells that are out of boundary or smaller
        c.) Get matrix max from every cell's max
        d.) Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
        e.) The key is to cache the distance because it's highly possible to revisit a cell
 */
public class Solution {

    private final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int ans = 1;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            ans = Math.max(ans, len);
        }
        cache[i][j] = ans;
        return ans;
    }
}