package Q0499.Q0416PartitionEqualSubsetSum;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition Equal Subset Sum.
public class Solution2 {
    private boolean[] memo;

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) > 0) return false;
        int target = sum / 2;
        memo = new boolean[target + 1];
        return DFS(nums, 0, target);
    }

    private boolean DFS(int[] nums, int ind, int target) {
        if (ind >= nums.length) return false;
        if (target - nums[ind] == 0) return true;

        if (target - nums[ind] > 0) {
            if (!memo[target - nums[ind]]) {
                memo[target - nums[ind]] = true;
                return DFS(nums, ind + 1, target - nums[ind]) || DFS(nums, ind + 1, target);
            }
        }

        return DFS(nums, ind + 1, target);
    }

}
