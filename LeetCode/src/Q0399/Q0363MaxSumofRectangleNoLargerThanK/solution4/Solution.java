package Q0399.Q0363MaxSumofRectangleNoLargerThanK.solution4;

// 执行用时：41 ms, 在所有 Java 提交中击败了100.00%的用户
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < col; i++) {
            int[] sum = new int[row];
            for (int j = i; j < col; j++) {
                for (int r = 0; r < row; r++) {
                    sum[r] += matrix[r][j];
                }
                int curr = 0;
                int max = sum[0];
                for (int n : sum) {
                    curr = Math.max(n, curr + n);
                    max = Math.max(curr, max);
                    if (max == k) return max;
                }
                if (max < k) {
                    res = Math.max(max, res);
                } else {
                    for (int a = 0; a < row; a++) {
                        int currSum = 0;
                        for (int b = a; b < row; b++) {
                            currSum += sum[b];
                            if (currSum <= k) res = Math.max(currSum, res);
                        }
                    }
                    if (res == k) return res;
                }
            }
        }
        return res;
    }
}