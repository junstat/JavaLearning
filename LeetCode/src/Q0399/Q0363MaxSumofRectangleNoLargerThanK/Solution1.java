package Q0399.Q0363MaxSumofRectangleNoLargerThanK;

import java.util.TreeSet;

public class Solution1 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        // boundary check
        if (matrix.length == 0) return 0;

        int m = matrix.length, n = matrix[0].length;
        int result = Integer.MIN_VALUE;

        // outer loop should use smaller axis
        // now we assume we have more rows than cols, therefore outer loop will be based on cols
        for (int left = 0; left < n; left++) {
            // array that accumulate sums for each row from left to right
            int[] sums = new int[m];
            for (int right = left; right < n; right++) {
                // update sums[] to include values in curr right col
                for (int i = 0; i < m; i++)
                    sums[i] += matrix[i][right];
                // we use TreeSet to help us find the rectangle with masSum <= k with O(log n) time
                TreeSet<Integer> set = new TreeSet<>();
                // add 0 to cover the single row case
                set.add(0);
                int curSum = 0;

                for (int sum : sums) {
                    curSum += sum;
                    // we use sum subtraction( curSum - sum) to get the subarray with sum <= k
                    // therefore we need to look for the smallest sum >= curSum - k
                    Integer num = set.ceiling(curSum - k);
                    if (num != null) result = Math.max(result, curSum - num);
                    set.add(curSum);
                }
            }
        }
        return result;
    }
}
