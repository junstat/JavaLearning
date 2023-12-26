package Q0099.Q0004.solution2;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, len = m + n;
        int left = -1, right = -1;
        int start1 = 0, start2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (start1 < m && (start2 >= n || nums1[start1] < nums2[start2])) {
                right = nums1[start1++];
            } else {
                right = nums2[start2++];
            }
        }

        return (len & 1) == 0 ? (left + right) / 2.0 : right;
    }
}
