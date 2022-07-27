package Q61.solution;

import java.util.Arrays;

public class Solution {
    public boolean IsContinuous(int[] nums) {
        int n = nums.length;
        int score = 0;
        Arrays.sort(nums);
        for (int num : nums) if (num == 0) score++;
        for (int i = score + 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) return false;
            score -= nums[i] - nums[i - 1] - 1;
        }
        return score >= 0;
    }
}