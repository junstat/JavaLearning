package Q0099.Q0081.solution1;

public class Solution {
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
