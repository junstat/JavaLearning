package Q0399.Q0376WiggleSubsequence.solution2;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int inc = 1, dec = 1, N = nums.length;
        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i - 1]) inc = dec + 1;
            else if (nums[i] < nums[i - 1]) dec = inc + 1;
        }
        return Math.max(inc, dec);
    }
}