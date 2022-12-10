package Q1899.Q1827MinimumOperationstoMaketheArrayIncreasing.solution;

public class Solution {
    public int minOperations(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            int goal = Math.max(nums[i - 1] + 1, nums[i]);
            ans += (goal - nums[i]);
            nums[i] = goal;
        }
        return ans;
    }
}
