package Q0299.Q0200NumberofIslands.solution2;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = m == 0 ? 0 : grid[0].length, islands = 0;
        int[] offset = {0, 1, 0, -1, 0};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islands++;
                    grid[i][j] = '0';
                    Queue<int[]> task = new ArrayDeque<>();
                    task.add(new int[]{i, j});
                    while (!task.isEmpty()) {
                        int[] p = task.poll();
                        for (int k = 0; k < 4; k++) {
                            int r = p[0] + offset[k], c = p[1] + offset[k + 1];
                            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                task.add(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
