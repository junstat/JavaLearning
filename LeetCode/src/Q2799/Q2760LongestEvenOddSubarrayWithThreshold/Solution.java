package Q2799.Q2760LongestEvenOddSubarrayWithThreshold;

public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length, cnt = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && oddEven(nums[i], nums[i - 1]) &&
                    Math.max(nums[i], nums[i - 1]) <= threshold) ++cnt;
            else cnt = nums[i] % 2 == 0 && nums[i] <= threshold ? 1 : 0;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    boolean oddEven(int a, int b) {
        return (a & 1) != (b & 1);
    }
}