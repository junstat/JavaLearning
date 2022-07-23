package Q0199.Q0152MaximumProductSubarray.review;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
    [Medium]
    Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product,
    and return the product.
    The test cases are generated so that the answer will fit in a 32-bit integer.
    A subarray is a contiguous subsequence of the array.

    Example 1:
    Input: nums = [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

    Example 2:
    Input: nums = [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class Solution {
    @Test
    public void test() {
        int[] nums = {2, 3, -2, 4};
        assertEquals(maxProduct(nums), 6);
    }

    public int maxProduct(int[] nums) {

        return 0;
    }
}