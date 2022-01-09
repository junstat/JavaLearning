package Q0099.Q0034FindFirstAndLastPositionOfElementInSortedArray;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Summary {

    @Test
    public void testFirstEqualElement() {
        int[] nums = {1, 2, 3, 3, 4, 5};
        int target = 3;
        assertEquals(findFirstEqualElement(nums, target), 2);

    }

    /*
      二分查找的经典写法:
      注意:
      1. 循环退出条件: low <= hi，而不是low < hi
      2. mid的取值: mid = low + (hi - low) >> 1
      3. low和hi的更新 low = mid + 1, hi = mid - 1
    */
    public int binarySearch(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) >> 1;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) hi = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    // 拓展
    // 一、二分查找第一个与target相等的元素, 时间复杂度 O(lg n)
    public int findFirstEqualElement(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) >> 1;
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) low = mid + 1;
            else {
                if ((mid == 0) || (nums[mid - 1] != target)) return mid;
                hi = mid - 1;
            }
        }
        return -1;
    }

    // 二、最后一个与target相等的元素，时间复杂度O(lg n)
    public int findLastEqualElement(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) >> 1;
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) low = mid + 1;
            else {
                if ((mid == nums.length - 1) || (nums[mid + 1] != target))
                    return mid;
                low = mid + 1;
            }
        }
        return -1;
    }

    // 第一个大于等于 target的元素 O(lg n)
    public int findFirstGreaterElement(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low < hi) {
            int mid = low + (hi - low) / 2;
            if (target <= nums[mid]) {
                if ((mid == 0) || (nums[mid - 1] < target))
                    return mid;
                hi = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 最后一个小于等于 target的元素, O(lg n)
    public int findLastLessElement(int[] nums, int target) {
        int low = 0, hi = nums.length - 1;
        while (low <= hi) {
            int mid = low + (hi - low) >> 1;
            if (target >= nums[mid]) {
                if ((mid == nums.length - 1) || (nums[mid + 1] > target))
                    return mid;
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }
}
