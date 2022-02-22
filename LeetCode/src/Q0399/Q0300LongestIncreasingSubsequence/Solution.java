package Q0399.Q0300LongestIncreasingSubsequence;

/*
    状态定义: dp[i]表示以nums[i]结尾的最长不下降子序列长度
    状态转移方程: dp[i] = max{1, dp[j] + 1}, nums[i] >= nums[j] and dp[j] + 1 > dp[i]
                i in [0, n), j in [0, i)
    边界: dp[i] = 1
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[j] + 1 > dp[i])
                    dp[i] = Math.max(1, dp[j] + 1);
            }
            if (dp[i] > ans) ans = dp[i];
        }
        return ans;
    }
}
