package Q0299.Q0215KthLargestElementinanArray;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    Given an integer array nums and an integer k, return the kth largest element in the array.
    Note that it is the kth largest element in the sorted order, not the kth distinct element.

    Example 1:
    Input: nums = [3,2,1,5,6,4], k = 2
    Output: 5

    Example 2:
    Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
    Output: 4
 */
public class Review {

    @Test
    public void test1() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        assertEquals(4, findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {

        return 0;
    }
}
