package Q0099.Q0074.solution2;

public class Solution {
    /*
      来自 《剑指offer》 第2版，面试题4
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (rows > 0 && columns > 0) {
            int row = 0;
            int column = columns - 1;

            while (row < rows && column >= 0) {
                if (matrix[row][column] == target) {
                    found = true;
                    break;
                } else if (matrix[row][column] > target) --column;
                else ++row;
            }
        }
        return found;
    }
}
