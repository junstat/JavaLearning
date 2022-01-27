package Q0199.Q0169MajorityElement;

import java.util.Arrays;

/*
    Sorting
 */
public class Solution2 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
