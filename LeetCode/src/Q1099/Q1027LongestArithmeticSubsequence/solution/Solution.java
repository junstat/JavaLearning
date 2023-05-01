package Q1099.Q1027LongestArithmeticSubsequence.solution;

public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int ans = 0, n = nums.length;
        int[][] f = new int[n][1010];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int d = nums[i] - nums[j] + 500;
                f[i][d] = Math.max(f[i][d], f[j][d] + 1);
                ans = Math.max(ans, f[i][d]);
            }
        }
        return ans + 1;
    }
}
