package Q0299.Q0221MaximalSquare.solution2;

import java.util.Arrays;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, sz = 0;
        int[] pre = new int[n], cur = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || matrix[i][j] == '0') {
                    cur[j] = matrix[i][j] - '0';
                } else {
                    cur[j] = Math.min(
                            pre[j - 1],
                            Math.min(pre[j], cur[j - 1])
                    ) + 1;
                }
                sz = Math.max(cur[j], sz);
            }
            // cur -> pre
            System.arraycopy(cur, 0, pre, 0, cur.length);
            Arrays.fill(cur, 0);
        }
        return sz * sz;
    }
}
