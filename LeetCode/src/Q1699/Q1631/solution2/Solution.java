package Q1699.Q1631.solution2;

public class Solution {
    int[][] h;
    boolean[][] visited;
    int rows, cols;

    public int minimumEffortPath(int[][] heights) {
        h = heights;
        rows = h.length;
        cols = h[0].length;
        int min = heights[0][0], max = 0;
        for (var row : heights) {
            for (int x : row) {
                min = Math.min(min, x);
                max = Math.max(max, x);
            }
        }
        int l = 0, r = max - min;
        while (l <= r) {
            visited = new boolean[rows][cols];
            int m = (l + r) >>> 1;
            if (!dfs(0, 0, m, h[0][0])) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    boolean dfs(int i, int j, int m, int prevH) {
        if (Math.abs(h[i][j] - prevH) > m) return false;
        if (i == rows - 1 && j == cols - 1) return true;
        visited[i][j] = true;
        int currH = h[i][j];
        return i < rows - 1 && !visited[i + 1][j] && dfs(i + 1, j, m, currH)
                || j < cols - 1 && !visited[i][j + 1] && dfs(i, j + 1, m, currH)
                || i > 0 && !visited[i - 1][j] && dfs(i - 1, j, m, currH)
                || j > 0 && !visited[i][j - 1] && dfs(i, j - 1, m, currH);
    }
}