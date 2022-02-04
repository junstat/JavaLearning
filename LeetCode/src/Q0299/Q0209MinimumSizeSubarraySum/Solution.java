package Q0299.Q0209MinimumSizeSubarraySum;

/*
   two pointers
   1. 用 i 、start 去夹
   2. win 做窗口
   time complexity: O(n)
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, start = 0, win = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                win = Math.min(win, i - start + 1);
                sum -= nums[start++];
            }
        }
        return (win == Integer.MAX_VALUE) ? 0 : win;
    }
}
