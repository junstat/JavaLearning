public class Solution2 {
    public int longestIncreasingPath(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                max = Math.max(max, traverse(i, j, matrix, dp));

        return max;
    }

    public int traverse(int i, int j, int[][] matrix, Integer[][] dp) {

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int max = 0;

        //up
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, traverse(i - 1, j, matrix, dp));
        }

        //down
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, traverse(i + 1, j, matrix, dp));
        }

        //left
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, traverse(i, j - 1, matrix, dp));
        }

        //right
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, traverse(i, j + 1, matrix, dp));
        }

        //matrix[i][j] = temp;
        return dp[i][j] = max + 1;
    }
}