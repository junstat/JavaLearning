package Q0499.Q0454FourSumII;

import java.util.Arrays;

// Runtime: 14 ms, faster than 99.99% of Java online submissions for 4Sum II.
public class Solution2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Arrays.sort(nums3);
        Arrays.sort(nums4);

        int length = nums1.length;

        int max = Math.max(nums3[length - 1] + nums4[length - 1], -nums1[0] - nums2[0]);
        int min = Math.min(nums3[0] + nums4[0], -nums1[length - 1] - nums2[length - 1]);

        int[] bucket = new int[max - min + 1];

        for (int k : nums3) {
            for (int l : nums4) {
                bucket[k + l - min]++;
            }
        }

        for (int i : nums1) {
            for (int j : nums2) {
                result += bucket[(i + j) * -1 - min];
            }
        }
        return result;
    }
}
