package Q0299.Q0217ContainsDuplicate.solution2;

import java.util.Arrays;

public class Solution {
    // Approach #2 (Sorting) [Accepted]
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == nums[i + 1]) return true;
        return false;
    }
}
