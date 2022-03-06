package Q0399.Q0324WiggleSortII;

import org.junit.Test;

import java.util.Arrays;

/*
    [Medium]
    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
    You may assume the input array always has a valid answer.

    Example 1:
    Input: nums = [1,5,1,1,6,4]
    Output: [1,6,1,5,1,4]
    Explanation: [1,4,1,5,1,6] is also accepted.

    Example 2:
    Input: nums = [1,3,2,2,3,1]
    Output: [2,3,1,3,1,2]
 */
public class Review {
    @Test
    public void test1() {
        int[] nums = {2, 3, 5, 5, 5, 6};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {1, 5, 1, 7, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void wiggleSort(int[] nums) {

    }
}
