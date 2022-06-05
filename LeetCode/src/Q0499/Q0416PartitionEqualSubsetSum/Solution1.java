package Q0499.Q0416PartitionEqualSubsetSum;

public class Solution1 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++)
            dp[i][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];  // 不选第i件物品
                if (j >= nums[i - 1])
                    dp[i][j] = (dp[i][j] || dp[i - 1][j - nums[i - 1]]);
            }
        }

        return dp[n][target];
    }
}
