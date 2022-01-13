package Q0099.Q0063UniquePathII;

/*
    DP
    1. 状态定义
        dp[i][j] 表示 到达grid[i][j]的路径数
    2. 初始状态
        dp[row][0] = 1  row in [0, rows]
        dp[0][col] = 1  col in [0, cols]

    3. 转态转移方程
        dp[i][j] = dp[i-1][j] + dp[i][j - 1]
        特别地，当obstacleGrid[i][j] = 1，意味着此路不通，dp[i][j] = 0
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];

        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) dp[j] = 0;
                else if (j > 0) dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
}
