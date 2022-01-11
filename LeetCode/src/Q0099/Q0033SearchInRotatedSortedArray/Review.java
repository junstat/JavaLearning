package Q0099.Q0033SearchInRotatedSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  There is an integer array nums sorted in ascending order (with distinct values).
  Prior to being passed to your function,
  nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
  such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
  For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
  Given the array nums after the possible rotation and an integer target,
  return the index of target if it is in nums, or -1 if it is not in nums.
  You must write an algorithm with O(log n) runtime complexity.

  Example 1:
  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4

  Example 2:
  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1

  Example 3:
  Input: nums = [1], target = 0
  Output: -1
 */
public class Review {
    @Test
    public void test1() {
        int[] nums = {1};
        int target = 1;
        assertEquals(search(nums, target), 0);
    }

    @Test
    public void test2() {
        int[] nums = {1, 3};
        int target = 3;
        assertEquals(search(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 3};
        int target = 1;
        assertEquals(search(nums, target), 0);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3};
        int target = 2;
        assertEquals(search(nums, target), -1);
    }

    public int search(int[] nums, int target) {

        return -1;
    }
}
