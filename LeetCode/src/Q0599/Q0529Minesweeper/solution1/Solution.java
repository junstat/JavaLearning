package Q0599.Q0529Minesweeper.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public char[][] updateBoard(char[][] A, int[] click) {
        int M = A.length, N = A[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{click[0], click[1]});
        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int x = p[0], y = p[1];
            if (A[x][y] == 'M') {
                A[x][y] = 'X';
                continue;
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
            if (cnt != 0) A[x][y] = (char) (cnt + '0');
            else {
                A[x][y] = 'B';
                for (int dx = -1; dx <= 1; ++dx) {
                    for (int dy = -1; dy <= 1; ++dy) {
                        if (dx == 0 && dy == 0) continue;
                        int a = x + dx, b = y + dy;
                        if (a < 0 || a >= M || b < 0 || b >= N || A[a][b] != 'E') continue;
                        A[a][b] = '#';
                        q.addLast(new int[]{a, b});
                    }
                }
            }
        }
        return A;
    }
}
