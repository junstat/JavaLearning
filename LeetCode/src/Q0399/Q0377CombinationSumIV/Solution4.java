package Q0399.Q0377CombinationSumIV;

import java.util.Arrays;

// Runtime: 1 ms, faster than 91.93% of Java online submissions for Combination Sum IV.
public class Solution4 {
    public int combinationSum4(int[] nums, int target) {
        if (target == 0) return 1;

        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);

        dp[0] = 1;

        helper(nums, target, dp);

        return dp[target];
    }

    public int helper(int[] nums, int target, int dp[]) {
        if (dp[target] != -1) return dp[target];

        int ans = 0;
        for (int i : nums) {
            if (i <= target) ans += helper(nums, target - i, dp);
        }
        dp[target] = ans;
        return ans;
    }
}
