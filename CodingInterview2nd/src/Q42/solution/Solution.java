package Q42.solution;

public class Solution {
    public int FindGreatestSumOfSubArray(int[] nums) {
        int curSum = 0, ans = nums[0];
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            ans = Math.max(ans, curSum);
        }
        return ans;
    }
}
