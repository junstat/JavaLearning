package Q0099.Q0085.review;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Hard]
  Given a rows x cols binary matrix filled with 0's and 1's,
  find the largest rectangle containing only 1's and return its area.

  Example 1:
  Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
  Output: 6
  Explanation: The maximal rectangle is shown in the above picture.
*/
public class Solution {
    @Test
    public void test1() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        assertEquals(maximalRectangle(matrix), 6);
    }

    public int maximalRectangle(char[][] matrix) {

        return 0;
    }
}
