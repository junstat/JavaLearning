package Q0299.Q0289GameofLife.solution;

/*
    使用2个二进制位来保存数据，低位保存当前状态，高位保存最终状态
    Step 1: 方法liveNeighbors，对于board[i][j] 遍历周围位置1个数
 */
public class Solution {
    int[][] board;
    int m, n;

    public void gameOfLife(int[][] _board) {
        board = _board;
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = liveNeighbors(i, j);

                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when weill the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;    // Make the 2nd bit 1: 01 -> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2;    // Make the 2nd bit 1: 00 -> 10
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;  // Get the 2nd state
            }
        }
    }

    private int liveNeighbors(int i, int j) {
        // 00 & 01 = 0, 01 & 01 = 01, 10 & 01 = 00, 11 & 01 = 11
        // 统计周围1个数
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
