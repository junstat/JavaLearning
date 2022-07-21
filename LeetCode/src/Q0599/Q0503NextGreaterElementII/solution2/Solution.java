package Q0599.Q0503NextGreaterElementII.solution2;

import java.util.Arrays;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        // 使用数组模拟栈，hh 代表栈底，tt 代表栈顶
        int[] d = new int[n * 2];
        int hh = 0, tt = -1;
        for (int i = 0; i < n * 2; i++) {
            while (hh <= tt && nums[i % n] > nums[d[tt]]) {
                int u = d[tt--];
                ans[u] = nums[i % n];
            }
            d[++tt] = i % n;
        }
        return ans;
    }
}