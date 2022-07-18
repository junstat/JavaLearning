package Q0499.Q0416PartitionEqualSubsetSum.solution3;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        int target = sum / 2;

        int n = nums.length;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = target; j >= 0; j--) {
                boolean no = dp[j];
                boolean yes = j >= t && dp[j - t];
                dp[j] = no || yes;
            }
        }
        return dp[target];
    }
}
