package Q0499.Q0480SlidingWindowMedian.solution1;

import java.util.Arrays;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int cnt = n - k + 1;
        double[] ans = new double[cnt];
        int[] t = new int[k];
        for (int l = 0, r = l + k - 1; r < n; l++, r++) {
            for (int i = l; i <= r; i++) t[i - l] = nums[i];
            Arrays.sort(t);
            ans[l] = (t[k / 2] / 2.0) + (t[(k - 1) / 2] / 2.0);
        }
        return ans;
    }
}