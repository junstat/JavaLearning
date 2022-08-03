package Q0099.Q0055JumpGame.solution2;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length, last = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}
