package Q0099.Q0079WordSearch;

public class Solution {
    /*
       Here accepted solution based on recursion. To save memory I decided to apply bit mask for every visited cell.
       Please check board[y][x] ^= 256;
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {  // y represent row number
            for (int j = 0; j < board[i].length; j++) {  // x represent col number
                if (exist(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    /*
      判断以网格的(i,j)位置出发，能否搜索到单词 word[k...]
     */
    private boolean exist(char[][] board, int i, int j, String word, int k) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i == board.length || j == board[i].length) return false;
        if (board[i][j] != word.charAt(k)) return false;
        board[i][j] ^= 256;  // 已检查过
        boolean exist = exist(board, i, j + 1, word, k + 1) // 右
                || exist(board, i, j - 1, word, k + 1) // 左
                || exist(board, i + 1, j, word, k + 1)  // 上
                || exist(board, i - 1, j, word, k + 1); // 下
        board[i][j] ^= 256;  // 恢复
        return exist;

    }
}