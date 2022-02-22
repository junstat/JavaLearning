package Q0299.Q0238ProductofArrayExceptSelf;

import org.junit.Test;

import java.util.Arrays;

/*
    [Medium]
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
    elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]
 */
public class Review {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    @Test
    public void test2() {
        int[] nums = {-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        return null;
    }
}
