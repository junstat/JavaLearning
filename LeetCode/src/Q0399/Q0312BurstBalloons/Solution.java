package Q0399.Q0312BurstBalloons;

public class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] balloons = new int[n]; // 加上左右边界
        balloons[0] = balloons[n - 1] = 1;
        System.arraycopy(nums, 0, balloons, 1, nums.length);

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++) {
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            balloons[left] * balloons[i] * balloons[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}