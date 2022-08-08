package Q0399.Q0300LongestIncreasingSubsequence.solution;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = dp[j] + 1;
            }
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }
}