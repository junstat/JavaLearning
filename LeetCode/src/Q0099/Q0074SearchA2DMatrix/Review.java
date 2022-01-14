package Q0099.Q0074SearchA2DMatrix;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
  [Medium]
  Write an efficient algorithm that searches for a value in an m x n matrix.
  This matrix has the following properties:
  Integers in each row are sorted from left to right.
  The first integer of each row is greater than the last integer of the previous row.
  Example 1:
  Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
  Output: true

  Example 2:
  Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
  Output: false
 */
public class Review {

    @Test
    public void test1() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        assertTrue(searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {

        return false;
    }
}