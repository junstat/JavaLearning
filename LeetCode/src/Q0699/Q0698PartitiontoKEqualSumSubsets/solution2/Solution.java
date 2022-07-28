package Q0699.Q0698PartitiontoKEqualSumSubsets.solution2;

import java.util.Arrays;

public class Solution {
    int[] nums, dp;
    int k, sum, n;

    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        n = nums.length;
        sum /= k;
        dp = new int[1 << n];  // -1 unvisited, 0 can't k-partition, 1 can k-partition
        Arrays.fill(dp, -1);
        dp[(1 << n) - 1] = 1; // If we can use all elements, it's a valid k-partition
        Arrays.sort(nums); // Try the rocks earlier than sands
        reverse();
        return dfs(0, sum);
    }

    boolean dfs(int mask, int t) {
        if (dp[mask] != -1) return dp[mask] == 1;
        dp[mask] = 0;
        if (t == 0) t = sum;
        for (int i = 0; i < n && dp[mask] == 0; i++) {
            // If `A[i]` is used in `mask`, or `A[i] > target`, skip this `A[i]`
            if (((mask >> i & 1) == 1) || nums[i] > t) continue;
            dp[mask] = dfs(mask | (1 << i), t - nums[i]) ? 1 : 0;
        }
        return dp[mask] == 1;
    }

    void reverse() {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int c = nums[l];
            nums[l++] = nums[r];
            nums[r--] = c;
        }
    }
}
