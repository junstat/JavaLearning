package Q0799.Q0795NumberofSubarrayswithBoundedMaximum.solution;

public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans = 0, dp = 0, pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left && i > 0) ans += dp;
            if (nums[i] > right) {
                dp = 0;
                pre = i;
            }
            if (left <= nums[i] && nums[i] <= right) {
                dp = i - pre;
                ans += dp;
            }
        }
        return ans;
    }
}