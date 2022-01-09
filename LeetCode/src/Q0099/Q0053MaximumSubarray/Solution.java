package Q0099.Q0053MaximumSubarray;

public class Solution {
    /**
     * dynamic programming
     * 1. 状态转移方程: f(i) = max{f(i - 1) + nums[i] , nums[i]}
     * 用变量 curSum 替代 f(i - 1)，res 替代 f(i) 以降低空间复杂度
     * 2. 初始状态: curSum = 0, res = nums[0]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // dynamic programming
        int res = nums[0];
        int curSum = 0;
        for (int num : nums) {
            // if (curSum > 0) curSum += num;
            // else curSum = num;
            curSum = Math.max(curSum + num, num);
            res = Math.max(res, curSum);
        }
        return res;
    }
}
