package Q0399.Q0398RandomPickIndex;

public class Solution {
    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
                if ((int) (Math.random() * count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }
}
