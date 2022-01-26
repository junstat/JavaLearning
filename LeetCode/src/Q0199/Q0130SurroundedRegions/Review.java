package Q0199.Q0130SurroundedRegions;

import org.junit.Test;

import java.util.Arrays;

/*
    [Medium]
    Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
    A region is captured by flipping all 'O's into 'X's in that surrounded region.

    Example 1:
    Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
    Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
    Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board
    are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will
    be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

    Example 2:
    Input: board = [["X"]]
    Output: [["X"]]
 */
public class Review {

    @Test
    public void test1() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    public void solve(char[][] board) {

    }
}