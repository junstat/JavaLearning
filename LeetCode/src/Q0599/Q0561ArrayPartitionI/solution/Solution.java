package Q0599.Q0561ArrayPartitionI.solution;

import java.util.Arrays;

public class Solution {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i += 2) ans += nums[i];
        return ans;
    }
}