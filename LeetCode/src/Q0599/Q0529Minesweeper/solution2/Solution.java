package Q0599.Q0529Minesweeper.solution2;

public class Solution {
    int M, N;
    char[][] A;

    public char[][] updateBoard(char[][] _A, int[] click) {
        A = _A;
        M = A.length;
        N = A[0].length;
        dfs(click[0], click[1]);
        return A;
    }

    void dfs(int x, int y) {
        if (A[x][y] == 'M') {
            A[x][y] = 'X';
            return;
        }
        int cnt = 0;
        for (int dx = -1; dx <= 1; ++dx) {
            for (int dy = -1; dy <= 1; ++dy) {
                if (dx == 0 && dy == 0) continue;
                int a = x + dx, b = y + dy;
                if (a < 0 || a >= M || b < 0 || b >= N) continue;
                cnt += A[a][b] == 'M' ? 1 : 0;
            }
        }
        if (cnt != 0) A[x][y] = (char) ('0' + cnt);
        else {
            A[x][y] = 'B';
            for (int dx = -1; dx <= 1; ++dx) {
                for (int dy = -1; dy <= 1; ++dy) {
                    if (dx == 0 && dy == 0) continue;
                    int a = x + dx, b = y + dy;
                    if (a < 0 || a >= M || b < 0 || b >= N || A[a][b] != 'E') continue;
                    dfs(a, b);
                }
            }
        }
    }
}
