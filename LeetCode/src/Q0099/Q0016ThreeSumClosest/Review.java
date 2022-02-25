package Q0099.Q0016ThreeSumClosest;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
  [Medium]
  Given an integer array nums of length n and an integer target,
  find three integers in nums such that the sum is closest to target.

  Return the sum of the three integers.

  You may assume that each input would have exactly one solution.

  Example 1:
  Input: nums = [-1,2,1,-4], target = 1
  Output: 2
  Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Review {

    @Test
    public void test1() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int result = threeSumClosest(nums, target);
        int expected = 2;
        assertEquals(expected, result);
    }

    public int threeSumClosest(int[] nums, int target) {

        return 0;
    }
}
