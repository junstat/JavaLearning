package Q0099.Q0035SearchInsertPosition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given a sorted array of distinct integers and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */
public class Review {
    @Test
    public void test1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        assertEquals(searchInsert(nums, target), 2);
    }

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;
        assertEquals(searchInsert(nums, target), 1);
    }

    @Test
    public void test3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        assertEquals(searchInsert(nums, target), 4);
    }

    @Test
    public void test4() {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        assertEquals(searchInsert(nums, target), 0);
    }

    public int searchInsert(int[] nums, int target) {

        return 0;
    }
}
