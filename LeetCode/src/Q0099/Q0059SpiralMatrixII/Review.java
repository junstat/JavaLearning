package Q0099.Q0059SpiralMatrixII;

import org.junit.Test;

import java.util.Arrays;

/*
    [Medium】
    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    Example 1:
    Input: n = 3
    Output: [[1,2,3],[8,9,4],[7,6,5]]

    Example 2:
    Input: n = 1
    Output: [[1]]
 */
public class Review {
    @Test
    public void test1() {
        int[][] result = generateMatrix(3);
        for (int[] nums : result) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public int[][] generateMatrix(int n) {

        return null;
    }
}
