package Q0099.Q0059SpiralMatrixII.solution2;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        // 定义四个方向
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int x = 0, y = 0, d = 0, i = 1; i <= n * n; i++) {
            ans[x][y] = i;
            // 下一步要到达的位置
            int nx = x + dirs[d][0], ny = y + dirs[d][1];
            // 如果下一步发生「溢出」或者已经访问过（说明四个方向已经走过一次）
            if (nx < 0 || nx >= n || ny < 0 || ny >= n || ans[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];
            }
            x = nx;
            y = ny;
        }
        return ans;
    }
}