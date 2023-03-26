package Q1699.Q1658MinimumOperationstoReduceXtoZero.solution2;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0, n = nums.length, right = n;
        while (right > 0 && sum + nums[right - 1] <= x) // 计算最长后缀
            sum += nums[--right];
        if (right == 0 && sum < x) return -1; // 全部移除也无法满足要求
        int ans = sum == x ? n - right : n + 1;
        for (int left = 0; left < n; ++left) {
            sum += nums[left];
            while (right < n && sum > x) // 缩小后缀长度
                sum -= nums[right++];
            if (sum > x) break; // 缩小失败，说明前缀过长
            if (sum == x) ans = Math.min(ans, left + 1 + n - right); // 前缀+后缀长度
        }
        return ans > n ? -1 : ans;
    }
}