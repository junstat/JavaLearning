package Q0599.Q0542_01Matrix.solution3;

public class Solution {
    public int[][] updateMatrix(int[][] A) {
        int M = A.length, N = A[0].length;
        int INT_MAX = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) if (A[i][j] != 0) A[i][j] = 0x3f3f3f3f;

        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = Math.min(A[i][j],
                        Math.min(i - 1 >= 0 ? A[i - 1][j] + 1 : INT_MAX,
                                j - 1 >= 0 ? A[i][j - 1] + 1 : INT_MAX));
            }
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                A[i][j] = Math.min(A[i][j],
                        Math.min(i + 1 < M ? A[i + 1][j] + 1 : INT_MAX,
                                j + 1 < N ? A[i][j + 1] + 1 : INT_MAX));
            }
        }
        return A;
    }
}
