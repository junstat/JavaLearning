package Q0299.Q0217ContainsDuplicate.solution1;

public class Solution {
    // Approach #1 (Naive Linear Search) [Time Limit Exceeded]
    public boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < i; j++)
                if (nums[j] == nums[i]) return true;
        return false;
    }
}
