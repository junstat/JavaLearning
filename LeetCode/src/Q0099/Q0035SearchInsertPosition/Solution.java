package Q0099.Q0035SearchInsertPosition;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution {
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
        int low = 0, hi = nums.length - 1;
        // Invariant: the desired index is between [low, high+1]
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            if (nums[mid] < target) low = mid + 1;
            else hi = mid - 1;
        }
        // (1) At this point, low > high. That is, low >= high+1
        // (2) From the invariant, we know that the index is between [low, high+1], so low <= high+1.
        //     Following from (1), now we know low == high+1.
        // (3) Following from (2), the index is between [low, high+1] = [low, low],
        //     which means that low is the desired index
        //     Therefore, we return low as the answer. You can also return high+1 as the result, since low == high+1
        return low;
    }
}
