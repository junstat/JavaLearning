package Q0199.Q0179LargestNumber.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
    Since the result may be very large, so you need to return a string instead of an integer.

    Example 1:
    Input: nums = [10,2]
    Output: "210"

    Example 2:
    Input: nums = [3,30,34,5,9]
    Output: "9534330"
 */
public class Solution {
    @Test
    public void test1() {
        int[] nums1 = {10, 2};
        assertEquals("210", largestNumber(nums1));
        int[] nums2 = {3, 30, 34, 5, 9};
        assertEquals("9534330", largestNumber(nums2));
    }

    public String largestNumber(int[] nums) {

        return null;
    }
}
