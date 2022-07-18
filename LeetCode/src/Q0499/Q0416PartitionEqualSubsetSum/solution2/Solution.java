package Q0499.Q0416PartitionEqualSubsetSum.solution2;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        int n = nums.length;
        boolean[][] dp = new boolean[2][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                boolean no = dp[(i - 1) & 1][j];
                boolean yes = j >= t && dp[(i - 1) & 1][j - t];
                dp[i & 1][j] = no || yes;
            }
        }
        return dp[n & 1][target];
    }
}
