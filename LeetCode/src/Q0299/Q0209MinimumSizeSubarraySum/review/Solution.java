package Q0299.Q0209MinimumSizeSubarraySum.review;

import org.junit.Test;

/*
    [Medium]
    Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
    subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is
    no such subarray, return 0 instead.

    Example 1:
    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

    Example 2:
    Input: target = 4, nums = [1,4,4]
    Output: 1

    Example 3:
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0
 */
public class Solution {
    @Test
    public void test() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, win = Integer.MAX_VALUE;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                win = Math.min(win, end - start + 1);
                sum -= nums[start++];
            }
        }
        return 0;
    }
}
