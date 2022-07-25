package Q0699.Q0643MaximumAverageSubarrayI.solution;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = 0, sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        ans = sum / k;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k]; // int add = nums[i], del = nums[i - k];
            ans = Math.max(ans, sum / k);
        }
        return ans;
    }
}