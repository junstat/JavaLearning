package Q2499.Q2439.solution;

public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            ans = Math.max(ans, (sum + i) / (i + 1));
        }
        return (int) ans;
    }
}