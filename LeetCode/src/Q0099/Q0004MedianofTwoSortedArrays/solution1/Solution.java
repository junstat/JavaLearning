package Q0099.Q0004MedianofTwoSortedArrays.solution1;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, len = m + n;
        int[] nums = new int[len];
        merge(nums1, nums2, nums);
        if (len % 2 != 0)
            return nums[len / 2];
        return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
    }


    public void merge(int[] nums1, int[] nums2, int[] nums) {
        int p1 = 0, p2 = 0, p = 0;
        while (p1 < nums1.length && p2 < nums2.length)
            nums[p++] = (nums1[p1] <= nums2[p2]) ? nums1[p1++] : nums2[p2++];
        if (p2 < nums2.length)
            System.arraycopy(nums2, p2, nums, p, nums2.length - p2);
        if (p1 < nums1.length)
            System.arraycopy(nums1, p1, nums, p, nums1.length - p1);
    }
}
