package Q0299.Q0221MaximalSquare.solution3;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, sz = 0, pre = 0;
        int[] cur = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = cur[j];
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    cur[j] = matrix[i][j] - '0';
                } else {
                    cur[j] = Math.min(
                            pre, Math.min(cur[j], cur[j - 1])
                    ) + 1;
                }
                sz = Math.max(cur[j], sz);
                pre = tmp;
            }
        }
        return sz * sz;
    }
}