package Q0899.Q0813LargestSumofAverages.solution;

public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] memo = new double[n + 1][n + 1];
        double cur = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            memo[i + 1][1] = cur / (i + 1);
        }

        return search(n, k, nums, memo);
    }

    double search(int n, int k, int[] nums, double[][] memo) {
        if (memo[n][k] > 0) return memo[n][k];
        if (n < k) return 0;
        double cur = 0;
        for (int i = n - 1; i > 0; i--) {
            cur += nums[i];
            memo[n][k] = Math.max(memo[n][k], search(i, k - 1, nums, memo) + cur / (n - i));
        }
        return memo[n][k];
    }
}

