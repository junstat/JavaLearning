package Q0199.Q0130SurroundedRegions;

/*
     We will use boundary DFS to solve this problem
     Let's analyze when an 'O' cannot be flipped,
     if it has at least one 'O' in it's adjacent, AND ultimately this chain of adjacent 'O's is connected to some
     'O' which lies on boundary of board

        consider these two cases for clarity :
        O's won't be flipped          O's will be flipped
        [X O X X X]                   [X X X X X]
        [X O O O X]                   [X O O O X]
        [X O X X X]                   [X O X X X]
        [X X X X X]                   [X X X X X]

      So we can conclude if a chain of adjacent O's is connected some O on boundary then they cannot be flipped

Steps to Solve :
1. Move over the boundary of board, and find O's
2. Every time we find an O, perform DFS from it's position
3. In DFS convert all 'O' to '#'      (why?? so that we can differentiate which 'O' can be flipped and which cannot be)
4. After all DFSs have been performed, board contains three elements,#,O and X
5. 'O' are left over elements which are not connected to any boundary O, so flip them to 'X'
6. '#' are elements which cannot be flipped to 'X', so flip them back to 'O'
 */
public class Solution {

    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') helper(board, i, 0);
            if (board[i][n - 1] == 'O') helper(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') helper(board, 0, j);
            if (board[m - 1][j] == 'O') helper(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void helper(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r > board.length - 1 || c > board[0].length - 1 || board[r][c] != 'O') return;
        board[r][c] = '#';
        helper(board, r + 1, c);
        helper(board, r - 1, c);
        helper(board, r, c + 1);
        helper(board, r, c - 1);
    }
}
