package Q0099.Q0055JumpGame.solution1;

public class Solution {
    public boolean canJump(int[] nums) {
        int i = 0, n = nums.length;
        for (int reach = 0; i < n && i <= reach; i++)
            reach = Math.max(i + nums[i], reach);
        return i == n;
    }
}