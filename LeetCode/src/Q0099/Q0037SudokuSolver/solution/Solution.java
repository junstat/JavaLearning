package Q0099.Q0037SudokuSolver.solution;

/*
    Straight Forward Java Solution Using Backtracking
    Try 1 through 9 for each cell. The time complexity should be 9 ^ m(m represents the number of blanks to be filled
     in), since each blank can have 9 choices.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        doSolve(board, 0, 0);
    }

    private boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {   // note: must reset col here!
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int blockRow = (row / 3) * 3, blockCol = (col / 3) * 3;   // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num || board[row][i] == num ||
                    board[blockRow + i / 3][blockCol + i % 3] == num)
                return false;
        }
        return true;
    }
}
