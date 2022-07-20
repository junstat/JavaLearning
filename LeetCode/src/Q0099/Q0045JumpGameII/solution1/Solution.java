package Q0099.Q0045JumpGameII.solution1;

public class Solution {
    public int jump(int[] nums) {
        int curEnd = 0, curFarthest = 0, steps = 0;

        for (int i = 0; i < nums.length - 1; i++) {  // 不访问最后一个元素
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (i == curEnd) {
                steps++;
                curEnd = curFarthest;
            }
            if (curEnd >= nums.length - 1) break;
        }
        return steps;
    }
}
