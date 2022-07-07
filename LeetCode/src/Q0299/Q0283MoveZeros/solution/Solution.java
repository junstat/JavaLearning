package Q0299.Q0283MoveZeros.solution;

public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int notZeroIndex = 0;
        for (int num : nums)
            if (num != 0) nums[notZeroIndex++] = num;
        while (notZeroIndex < nums.length) nums[notZeroIndex++] = 0;
    }
}
