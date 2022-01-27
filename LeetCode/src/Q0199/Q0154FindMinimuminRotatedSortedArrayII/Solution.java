package Q0199.Q0154FindMinimuminRotatedSortedArrayII;

public class Solution {

    /*
       When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let upper
       bound reduce one.
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid + 1;
            else if (nums[mid] < nums[end]) end = mid;
            else end--;   // when nums[mid] and nums[start] are same
        }
        return nums[start];
    }
}
