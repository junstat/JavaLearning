package Q0099.Q0079WordSearch.review;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
    [Medium]
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.
    The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
     vertically neighboring. The same letter cell may not be used more than once.

    Example 1:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    Output: true

    Example 2:
    Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
    Output: true
 */
public class Solution {

    @Test
    public void test1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = exist(board, word);
        assertTrue(result);
    }

    public boolean exist(char[][] board, String word) {

        return false;
    }
}