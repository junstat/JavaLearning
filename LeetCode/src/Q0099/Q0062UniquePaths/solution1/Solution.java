package Q0099.Q0062UniquePaths.solution1;

public class Solution {
    public int uniquePaths(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) dp[row][0] = 1;

        for (int col = 0; col < cols; col++) dp[0][col] = 1;

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[rows - 1][cols - 1];
    }
}
/*
   Similar questions:
    91. Decode Ways
    70. Climbing Stairs
    509. Fibonacci Number
 */