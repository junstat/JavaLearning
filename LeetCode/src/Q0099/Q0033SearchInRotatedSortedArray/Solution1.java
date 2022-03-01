package Q0099.Q0033SearchInRotatedSortedArray;

public class Solution1 {
    /*
       method 1:
        step 1: 找到nums中的最小值，即为数组元素的偏移量；
        step 2: 执行普通二分查找，不过每次中点 + 偏移量。
       Time: O(log n), Space: O(1)
     */
    public int search(int[] nums, int target) {
        // corner case
        if (nums == null || nums.length == 0) return -1;
        int low = 0, n = nums.length, high = n - 1;
        /*
           Find the index of the smallest value using binary search.
           Loop will terminate since mid < high, and low or hi will shrink by at least 1.
           Proof by contradiction that mid < high:
           if mid == high, then low == high and loop would have been terminated.
         */
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        // low = high is the index of the smallest value and also the number of places rotated.
        int rotated = low;
        low = 0;
        high = n - 1;
        // The usual binary search and accounting for rotation.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + rotated) % n;
            if (nums[realMid] == target) return realMid;
            else if (nums[realMid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}