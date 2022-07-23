package Q0599.Q0542_01Matrix.solution1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[][] updateMatrix(int[][] A) {
        int M = A.length, N = A[0].length, step = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int INT_MAX = Integer.MAX_VALUE;
        int[][] ans = new int[M][N];
        for (int i = 0; i < M; i++) Arrays.fill(ans[i], INT_MAX);
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 0) {
                    d.addLast(new int[]{i, j});
                    ans[i][j] = 0;
                }
            }
        }
        while (!d.isEmpty()) {
            int cnt = d.size();
            while (cnt-- > 0) {
                int[] p = d.pollFirst();
                int x = p[0], y = p[1];
                for (int[] dir : dirs) {
                    int dx = dir[0], dy = dir[1];
                    int a = x + dx, b = y + dy;
                    if (a < 0 || a >= M || b < 0 || b >= N || ans[a][b] != INT_MAX) continue;
                    d.addLast(new int[]{a, b});
                    ans[a][b] = step;
                }
            }
            ++step;
        }
        return ans;
    }
}
