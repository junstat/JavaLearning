package Q0599.Q0594LongestHarmoniousSubsequence.solution1;

import java.util.Arrays;

public class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) i++;
            if (nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}