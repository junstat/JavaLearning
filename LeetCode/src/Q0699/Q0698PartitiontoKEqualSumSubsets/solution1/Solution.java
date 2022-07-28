package Q0699.Q0698PartitiontoKEqualSumSubsets.solution1;

import java.util.Arrays;

public class Solution {
    int[] nums, sides;
    int k, t;

    public boolean canPartitionKSubsets(int[] _nums, int _k) {
        nums = _nums;
        k = _k;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0) return false;
        t = sum / k;
        sides = new int[k];
        Arrays.sort(nums); // Try the rocks earlier than sands
        reverse();
        return dfs(0);
    }

    boolean dfs(int i) {
        if (i == nums.length) return true;
        for (int j = 0; j < k; j++) {
            if (sides[j] + nums[i] > t) continue;
            sides[j] += nums[i];
            if (dfs(i + 1)) return true;
            sides[j] -= nums[i];
            if (sides[j] == 0) break; // don't try empty buckets multiple times.
        }
        return false;
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