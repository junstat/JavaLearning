package Q0799.Q0718MaximumLengthofRepeatedSubarray.solution;

public class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) return findLength(nums2, nums1);
        int m = nums1.length, n = nums2.length, ans = 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                dp[j + 1] = nums1[i] == nums2[j] ? 1 + dp[j] : 0;
                ans = Math.max(ans, dp[j + 1]);
            }
        }
        return ans;
    }
}