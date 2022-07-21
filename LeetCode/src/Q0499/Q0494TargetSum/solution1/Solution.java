package Q0499.Q0494TargetSum.solution1;

public class Solution {
    public int findTargetSumWays(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }
    int dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            return cur == t ? 1 : 0;
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        return left + right;
    }
}