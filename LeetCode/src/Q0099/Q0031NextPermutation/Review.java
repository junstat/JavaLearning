package Q0099.Q0031NextPermutation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * <p>
 * If such an arrangement is impossible,
 * it must rearrange it to the lowest possible order (i.e., sorted in ascending order).
 * <p>
 * The replacement must be in place and use only constant extra memory.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * <p>
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 */
public class Review {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 3, 2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            assertEquals(nums[i], expected[i]);
        }
    }

    public void nextPermutation(int[] nums) {
        
    }
}
