package Q0699.Q0695MaxAreaofIsland.solution2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                grid[i][j] = 0;
                int cnt = 0;
                while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    int x = pos[0], y = pos[1];
                    for (int[] dir : dirs) {
                        int dx = dir[0], dy = dir[1];
                        int a = x + dx, b = y + dy;
                        if (a < 0 || a >= m || b < 0 || b >= n || grid[a][b] == 0) continue;
                        grid[a][b] = 0;
                        q.add(new int[]{a, b});
                    }
                    ++cnt;
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}