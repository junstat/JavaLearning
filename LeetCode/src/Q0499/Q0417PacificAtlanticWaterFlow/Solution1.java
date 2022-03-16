package Q0499.Q0417PacificAtlanticWaterFlow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }
        int n = heights.length, m = heights[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) { //Vertical border
            pQueue.offer(new int[]{i, 0});
            aQueue.offer(new int[]{i, m - 1});
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) { //Horizontal border
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{n - 1, i});
            pacific[0][i] = true;
            atlantic[n - 1][i] = true;
        }
        bfs(heights, pQueue, pacific);
        bfs(heights, aQueue, atlantic);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    public void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int n = heights.length, m = heights[0].length;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < heights[cur[0]][cur[1]]) {
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}