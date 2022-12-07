package Q1799.Q1775EqualSumArraysWithMinimumNumberofOperations.solution;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            return minOperations(nums2, nums1);
        }

        int diff = sum2 - sum1;
        int[] freq = new int[6];
        for (int num : nums1) {
            ++freq[6 - num];
        }
        for (int num : nums2) {
            ++freq[num - 1];
        }

        int ans = 0;
        for (int i = 5; i >= 1 && diff > 0; --i) {
            while (freq[i] != 0 && diff > 0) {
                ++ans;
                --freq[i];
                diff -= i;
            }
        }
        return (diff > 0 ? -1 : ans);
    }
}