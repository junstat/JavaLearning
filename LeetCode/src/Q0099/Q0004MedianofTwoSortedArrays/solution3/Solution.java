package Q0099.Q0004MedianofTwoSortedArrays.solution3;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1); // 保证 nums1是短的
        int lo = 0, hi = nums1.length, m = nums1.length, n = nums2.length, len = m + n;
        // 在nums1上执行二分查找
        while (lo <= hi) {
            int cut1 = lo + (hi - lo) / 2;
            int cut2 = len / 2 - cut1;  // 根据 a. 及 cut1 => cut2，隔断两侧数量相等
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2) hi = cut1 - 1;    // left_part 长了
            else if (l2 > r1) lo = cut1 + 1;  // right_part 短了
            else {
                if (len % 2 == 0) return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else return Math.min(r1, r2);
            }
        }
        return -1;
    }
}
