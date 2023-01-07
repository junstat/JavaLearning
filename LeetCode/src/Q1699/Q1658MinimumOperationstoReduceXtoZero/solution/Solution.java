package Q1699.Q1658MinimumOperationstoReduceXtoZero.solution;

public class Solution {
    public int minOperations(int[] nums, int x) {
        //预处理
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //如果最小值都大于x或者总和小于x不符合
        if (sum < x) return -1;
        int n = nums.length;
        //如果总和刚好等于x,直接返回全部
        if (sum == x) return n;
        int maxL = 0; //窗口的长度
        int l = 0, r = 0;
        while (r < n) {
            sum -= nums[r];
            while (sum < x) {
                sum += nums[l++];
            }
            if (sum == x) maxL = Math.max(maxL, r + 1 - l);
            r++;
        }
        return maxL == 0 ? -1 : n - maxL;
    }
}