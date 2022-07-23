package Q12.solution;

public class Solution {
    char[][] board;
    int m, n;
    String word;
    boolean[][] visited;
    int pathLen = 0;

    public boolean hasPath(char[][] _board, String _word) {
        board = _board;
        word = _word;
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) return true;
            }
        }
        return false;
    }

    boolean dfs(int i, int j) {
        if (pathLen == word.length()) return true;
        boolean ans = false;
        if (i >= 0 && i < m && j >= 0 && j < n
                && board[i][j] == word.charAt(pathLen) && !visited[i][j]) {
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