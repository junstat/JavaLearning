package Q0799.Q0766ToeplitzMatrix.solution2;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int row = m, col = n;
        while (col-- > 0) {
            for (int i = 0, j = col, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if (matrix[i][j] != val) return false;
            }
        }
        while (row-- > 0) {
            for (int i = row, j = 0, val = matrix[i++][j++]; i < m && j < n; i++, j++) {
                if (matrix[i][j] != val) return false;
            }
        }
        return true;
    }
}