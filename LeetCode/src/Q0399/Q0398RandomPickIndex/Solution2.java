package Q0399.Q0398RandomPickIndex;

// Runtime: 46 ms, faster than 97.57% of Java online submissions for Random Pick Index.
public class Solution2 {
    int[] nums;

    public Solution2(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
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
