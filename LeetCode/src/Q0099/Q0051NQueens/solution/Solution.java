package Q0099.Q0051NQueens.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> res = new ArrayList<>();
    char[][] chess;

    public List<List<String>> solveNQueens(int n) {
        chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) chess[i][j] = '.';
        }
        solve(0);
        return res;
    }

    void solve(int row) {
        if (row == chess.length) {
            res.add(construct());
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (valid(row, col)) {
                chess[row][col] = 'Q';
                solve(row + 1);
                chess[row][col] = '.';
            }
        }
    }

    boolean valid(int row, int col) {
        // check all cols |
        for (int i = 0; i < row; i++)
            if (chess[i][col] == 'Q') return false;

        // check 45 degree /
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++)
            if (chess[i][j] == 'Q') return false;
        // check 135 degree \
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (chess[i][j] == 'Q') return false;

        return true;
    }

    List<String> construct() {
        List<String> path = new ArrayList<>();
        for (char[] chars : chess)
            path.add(new String(chars));
        return path;
    }
}