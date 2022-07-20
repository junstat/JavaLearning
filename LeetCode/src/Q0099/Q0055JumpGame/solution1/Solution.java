package Q0099.Q0055JumpGame.solution1;

public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++)
            reach = Math.max(i + nums[i], reach);
        return i == nums.length;
    }
}
