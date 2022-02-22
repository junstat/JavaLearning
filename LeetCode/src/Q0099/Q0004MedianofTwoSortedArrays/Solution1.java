package Q0099.Q0004MedianofTwoSortedArrays;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    把两个有序数组合并成一个有序数组，然后按上面的定义求一个数组的中位数。
    中位数求法, 先排序，若数组长度是奇数，就取正中间的那个数，如数组长度是偶数，则取中间两个数的平均值。
    time complexity: 遍历了全部数组，O(m+n)
    space complexity: 开辟了一个数组，保存合并后的两个数组，O(m+n)
 */
public class Solution1 {

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
