package Q0499.Q0407TrappingRainWaterII;

import java.util.PriorityQueue;

public class Solution3 {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        // 建立一个小根堆，存储(x, y, h)三元组信息(h为位置(x, y)的最终高度)
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            q.add(new int[]{0, i, heightMap[0][i]});    // 第一行
            q.add(new int[]{m - 1, i, heightMap[m - 1][i]}); // 最后一行
            vis[0][i] = vis[m - 1][i] = true;
        }
        for (int i = 1; i < m - 1; i++) {
            q.add(new int[]{i, 0, heightMap[i][0]});    // 第一列
            q.add(new int[]{i, n - 1, heightMap[i][n - 1]}); // 最后一列
            vis[i][0] = vis[i][n - 1] = true;
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // 右、左、上、下
        int ans = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0], y = poll[1], h = poll[2];
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (vis[nx][ny]) continue;
                if (h > heightMap[nx][ny]) ans += h - heightMap[nx][ny];
                q.add(new int[]{nx, ny, Math.max(heightMap[nx][ny], h)});
                vis[nx][ny] = true;
            }
        }
        return ans;
    }
}