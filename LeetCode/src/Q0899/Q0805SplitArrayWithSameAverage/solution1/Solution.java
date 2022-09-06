package Q0899.Q0805SplitArrayWithSameAverage.solution1;

public class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = 0, n = nums.length;
        for (int num : nums) sum += num;
        boolean[][] dp = new boolean[sum + 1][nums.length / 2 + 1];
        dp[0][0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                for (int j = 1; j <= n / 2; j++) dp[i][j] = dp[i][j] || dp[i - num][j - 1];
            }
        }
        for (int i = 1; i <= n / 2; ++i)
            if (sum * i % n == 0 && dp[sum * i / n][i]) return true;
        return false;
    }
}
