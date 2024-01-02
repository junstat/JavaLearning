package Q0099.Q0064.solution2;

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] pre = new int[m];
        int[] cur = new int[m];

        pre[0] = grid[0][0];

        for (int i = 1; i < m; i++)
            pre[i] = pre[i - 1] + grid[i][0];

        for (int j = 1; j < n; j++) {
            cur[0] = pre[0] + grid[0][j];
            for (int i = 1; i < m; i++)
                cur[i] = Math.min(cur[i - 1], pre[i]) + grid[i][j];
            swapArray(pre, cur);
        }
        return pre[m - 1];
    }

    private void swapArray(int[] pre, int[] cur) {
        for (int i = 0; i < pre.length; i++) {
            int tmp = pre[i];
            pre[i] = cur[i];
            cur[i] = tmp;
        }
    }
}
