package Q0399.Q0377CombinationSumIV;

import java.util.Arrays;

/*
    Now for a DP solution, we just need to figure out a way to store the intermediate results, to avoid the same
    combination sum being calculated many times. We can use an array to save those results, and check if there is
    already a result before calculation. We can fill the array with -1 to indicate that the result hasn't been
    calculated yet. 0 is not a good choice because it means there is no combination sum for the target.
 */
public class Solution2 {
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i]);
            }
        }
        dp[target] = res;
        return res;
    }
}
