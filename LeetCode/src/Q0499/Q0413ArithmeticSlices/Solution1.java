package Q0499.Q0413ArithmeticSlices;

public class Solution1 {
    public int numberOfArithmeticSlices(int[] nums) {
        int cur = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            // nums[i-2], nums[i-1], nums[i] 是否为等差数列
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                cur += 1;
                sum += cur;
            } else {
                cur = 0;
            }
        }
        return sum;
    }
}