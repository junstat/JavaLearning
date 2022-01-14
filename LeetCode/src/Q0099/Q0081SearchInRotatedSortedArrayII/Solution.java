package Q0099.Q0081SearchInRotatedSortedArrayII;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
    The idea is the same as the previous one without duplicates
    1) everytime check if target == nums[mid], if so, we find it.
    2) otherwise, we check if the first half is in order (i.e. nums[left]<=nums[mid])
       and if so, go to step 3), otherwise, the second half is in order,   go to step 4)
    3) check if target in the range of [left, mid-1] (i.e. nums[left]<=target < nums[mid]),
       if so, do search in the first half, i.e. right = mid-1; otherwise, search in the second half left = mid+1;
    4)  check if target in the range of [mid+1, right] (i.e. nums[mid]<target <= nums[right]), if so,
    do search in the second half, i.e. left = mid+1; otherwise search in the first half right = mid-1;

    The only difference is that due to the existence of duplicates, we can have nums[left] == nums[mid]
    and in that case, the first half could be out of order (i.e. NOT in the ascending order,
    e.g. [3 1 2 3 3 3 3]) and we have to deal this case separately. In that case,
    it is guaranteed that nums[right] also equals to nums[mid], so what we can do is to check
    if nums[mid]== nums[left] == nums[right] before the original logic, and if so, we can move left and
    right both towards the middle by 1. and repeat.
 */
public class Solution {
    @Test
    public void test1() {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        boolean result = search(nums, target);
        assertTrue(result);
    }

    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (nums[mid] == target) return true;

            // the only difference from the first one, tricky case, just update lo and hi
            if ((nums[lo] == nums[mid]) && (nums[hi] == nums[mid])) {
                ++lo;
                --hi;
            } else if (nums[lo] <= nums[mid]) {
                if ((nums[lo] <= target) && (nums[mid] > target)) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if ((nums[mid] < target) && (nums[hi] >= target)) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }
}
