package Q0699.Q0674LongestContinuousIncreasingSubsequence.solution;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int ans = 1, cnt = 1, n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) ++cnt;
            else cnt = 1;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}