package Q0499.Q0494TargetSum.solution2;

public class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int t) {
        dfs(nums, t, 0, 0);
        return ans;
    }
    void dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            ans += cur == t ? 1 : 0;
            return;
        }
        dfs(nums, t, u + 1, cur + nums[u]);
        dfs(nums, t, u + 1, cur - nums[u]);
    }
}