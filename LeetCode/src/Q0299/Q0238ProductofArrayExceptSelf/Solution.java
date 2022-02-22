package Q0299.Q0238ProductofArrayExceptSelf;

public class Solution {

    /*
       res[i] = nums[0] * nums[1] * ... * nums[i-1] * nums[i+1] * ... * nums[n-1]
       分为两部分计算:
       1) nums[0] * nums[1] * ... * nums[i-1]
       2) nums[i+1] * ... * nums[n-1]
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        // 1) nums[0] * nums[1] * ... * nums[i-1]
        for (int i = 1; i < n; i++) res[i] = res[i - 1] * nums[i - 1];
        int right = 1;
        // 2) nums[i+1] * ... * nums[n-1]
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}
