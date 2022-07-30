package Q0799.Q0724FindPivotIndex.solution2;

public class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0, sum = 0;
        // 我们的 nums 处理不涉及并行操作，使用循环要比 Arrays.stream 快
        // total = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) total += nums[i];
        for (int i = 0; i < n; i++) {
            if (sum == total - sum - nums[i]) return i;
            sum += nums[i];
        }
        return -1;
    }
}