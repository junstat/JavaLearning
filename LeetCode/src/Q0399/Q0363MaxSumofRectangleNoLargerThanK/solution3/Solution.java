package Q0399.Q0363MaxSumofRectangleNoLargerThanK.solution3;

import java.util.Arrays;
import java.util.TreeSet;

public class Solution {
    public int maxSumSubmatrix(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        boolean isRight = n > m;
        int[] sum = isRight ? new int[n + 1] : new int[m + 1];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= (isRight ? m : n); i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j <= (isRight ? m : n); j++) {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(0);
                int a = 0;
                for (int fixed = 1; fixed <= (isRight ? n : m); fixed++) {
                    sum[fixed] += isRight ? mat[j - 1][fixed - 1] : mat[fixed - 1][j - 1];
                    a += sum[fixed];
                    Integer b = ts.ceiling(a - k);
                    if (b != null) {
                        int cur = a - b;
                        ans = Math.max(ans, cur);
                    }
                    ts.add(a);
                }
            }
        }
        return ans;
    }
}