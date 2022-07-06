package Q0299.Q0219ContainsDuplicateII.review;

import org.junit.Test;

/*
    [Easy]
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.

    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true

    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true

    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
 */
public class Solution{
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    @Test
    public void test2() {
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        return false;
    }
}
