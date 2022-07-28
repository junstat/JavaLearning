package Q0699.Q0665NonDecreasingArray.solution2;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        for (int i = 1, cnt = 0; i < nums.length; i++) {
            if (nums[i] >= nums[i - 1]) continue;
            if (++cnt > 1) return false;
            if (i - 2 < 0 || Math.min(nums[i], nums[i - 1]) >= nums[i - 2])
                nums[i] = nums[i - 1] = Math.min(nums[i], nums[i - 1]);
            else nums[i] = nums[i - 1] = Math.max(nums[i], nums[i - 1]);
        }
        return true;
    }
}
