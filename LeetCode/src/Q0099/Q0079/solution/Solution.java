package Q0099.Q0079.solution;

public class Solution {
    char[][] board;
    boolean[][] visited;
    int m, n;
    char[] word;
    int pathLen = 0;

    public boolean exist(char[][] _board, String _word) {
        board = _board;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        word = _word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j) {
        if (pathLen == word.length) return true;
        boolean ans = false;
        if (i >= 0 && i < m && j >= 0 && j < n
                && board[i][j] == word[pathLen] && !visited[i][j]) {
            ++pathLen;
            visited[i][j] = true;
            ans = dfs(i, j - 1) || dfs(i - 1, j) || dfs(i, j + 1) || dfs(i + 1, j);
            if (!ans) {
                --pathLen;
                visited[i][j] = false;
            }
        }
        return ans;
    }
}