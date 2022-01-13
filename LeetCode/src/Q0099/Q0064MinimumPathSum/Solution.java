package Q0099.Q0064MinimumPathSum;


/*
    1. 状态定义
       minSum[i][j] 表示 到达grid[i][j]是的路径最小和
    2. 初始状态
       首行(i=0) minSum[i][j] = minSum[i][j - 1] + grid[i][j]
       首列(j=0) minSum[i][j] = minSum[i - 1][j] + grid[i][j]
    3. 状态转移方程
        minSum[i][j] = min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j]
 */
public class Solution {
    /*
      This is a typical DP problem. Suppose the minimum path sum of arriving at point (i, j) is S[i][j], then the state
    equation is S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j].
      Well, some boundary conditions need to be handled. The boundary conditions happen on the topmost row (S[i - 1][j]
    does not exist) and the leftmost column (S[i][j - 1] does not exist). Suppose grid is like [1, 1, 1, 1], then the
    minimum sum to arrive at each point is simply an accumulation of previous points and the result is [1, 2, 3, 4].
      Now we can write down the following (unoptimized) code.
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] minSum = new int[m][n];
        minSum[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 若 i = 0, 就不计算 i - 1，否则越界
                if (i == 0 && j > 0) minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                else if (j == 0 && i > 0) minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                else if (i > 0 && j > 0) minSum[i][j] = Math.min(minSum[i][j - 1], minSum[i - 1][j]) + grid[i][j];
            }
        }
        return minSum[m - 1][n - 1];
    }
}