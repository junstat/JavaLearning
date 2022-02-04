package Q0199.Q0198HouseRobber;

/*
    Dynamic Programming
    Intution: At every i-th house we have two choices to make, i.e., rob the i-th house or don't rob it.

    Case1 : Don't rob the i-th house - then we can rob the i-1 th house...so we will have max money robbed till i-1
    th house
    Case 2 : Rob the i-th house - then we cann't rob the i-1 th house but we can rob i-2 th house....so we will have
    max money robbed till i-2 th house + money of i-th house.
    Example:
    1.) If the array is [1,5,3] then robber will rob the 1st index house because arr[1] > arr[0]+arr[2] (i.e., at
    last index, arr[i-1] > arr[i-2]+arr[i])
    2.) If the array is [1,2,3] then robber will rob the 0th and 2nd index house because arr[0]+arr[2] > arr[1] (i.e
    ., at last index, arr[i-2] + arr[i] > arr[i-1])
 */
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // 1. 状态定义，i-th house的收益
        int[] dp = new int[nums.length];
        // 2. 初始状态
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++)
            // 3. 状态转移方程    Case 2              Case 1
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        return dp[nums.length - 1];
    }
}
