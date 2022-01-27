package Q0199.Q0164MaximumGap;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Hard]
    Given an integer array nums, return the maximum difference between two successive elements in its sorted form. If
    the array contains less than two elements, return 0.
    You must write an algorithm that runs in linear time and uses linear extra space.

    Example 1:
    Input: nums = [3,6,9,1]
    Output: 3
    Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.

    Example 2:
    Input: nums = [10]
    Output: 0
    Explanation: The array contains less than 2 elements, therefore return 0.
 */
public class Review {
    @Test
    public void test1() {
        int[] nums = {3, 6, 9, 1};
        int result = maximumGap(nums);
        assertEquals(3, result);
    }

    public int maximumGap(int[] nums) {

        return 0;
    }
}
