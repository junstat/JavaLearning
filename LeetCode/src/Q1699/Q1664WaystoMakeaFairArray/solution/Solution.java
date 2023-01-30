package Q1699.Q1664WaystoMakeaFairArray.solution;

public class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + (i % 2 != 0 ? nums[i - 1] : -nums[i - 1]);
        }
        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dp[i - 1] == dp[n] - dp[i]) ans++;
        }
        return ans;
    }
}