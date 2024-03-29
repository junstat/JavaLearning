package Q0099.Q0041.review;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
  [Hard]
  Given an unsorted integer array nums, return the smallest missing positive integer.
  You must implement an algorithm that runs in O(n) time and uses constant extra space.

  Example 1:
  Input: nums = [1,2,0]
  Output: 3

  Example 2:
  Input: nums = [3,4,-1,1]
  Output: 2

  Example 3:
  Input: nums = [7,8,9,11,12]
  Output: 1
 */
public class Solution {

    @Test
    public void test1() {
        int[] nums = {3, 4, -1, 1};
        assertEquals(2, firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        return 0;
    }
}
