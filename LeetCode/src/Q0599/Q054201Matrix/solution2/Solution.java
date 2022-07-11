package Q0599.Q054201Matrix.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[][] updateMatrix(int[][] A) {
        int M = A.length, N = A[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int INT_MAX = Integer.MAX_VALUE;
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) d.addLast(new int[]{i, j});
                else A[i][j] = INT_MAX;
            }
        }
        while (!d.isEmpty()) {
            int[] p = d.pollFirst();
            int x = p[0], y = p[1];
            for (int[] dir : dirs) {
                int dx = dir[0], dy = dir[1];
                int a = x + dx, b = y + dy;
                if (a < 0 || a >= M || b < 0 || b >= N || A[a][b] != INT_MAX) continue;
                d.addLast(new int[]{a, b});
                A[a][b] = A[x][y] + 1;
            }
        }
        return A;
    }
}
