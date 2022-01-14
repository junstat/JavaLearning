package Q0099.Q0073SetMatrixZeroes;

import org.junit.Test;

/*
    [Medium]
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's,
    and return the matrix.
    You must do it in place.

    Example 1:
    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Example 2:
    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class Review {
    @Test
    public void test1() {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix);
    }

    public void setZeroes(int[][] matrix) {

    }
}
