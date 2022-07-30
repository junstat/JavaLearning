package Q0799.Q0724FindPivotIndex.solution1;

public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        for (int i = 1; i <= n; i++) {
            int left = sum[i - 1], right = sum[n] - sum[i];
            if (left == right) return i - 1;
        }
        return -1;
    }
}