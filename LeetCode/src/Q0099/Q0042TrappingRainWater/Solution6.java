package Q0099.Q0042TrappingRainWater;

public class Solution6 {
    public int trap(int[] height) {
        int n = height.length;

        int sum = 0, max = 0;
        for (int cur : height) {
            sum += cur;
            max = Math.max(max, cur);
        }
        int full = max * n;

        int lSum = 0, lMax = 0;
        for (int j : height) {
            lMax = Math.max(lMax, j);
            lSum += lMax;
        }

        int rSum = 0, rMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            rMax = Math.max(rMax, height[i]);
            rSum += rMax;
        }

        return lSum + rSum - full - sum;
    }
}
