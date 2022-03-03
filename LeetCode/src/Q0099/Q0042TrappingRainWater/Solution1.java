package Q0099.Q0042TrappingRainWater;

public class Solution1 {
    /*
       For column_i, the rain it can trap:
                    左边最大值      右边最大值
         r[i] = min( max(h[0~i]), max(h[i~n-1]) )  - h[i]
       Approach 1: Brute force
       For each column, find max of left and right which takes O(n)
       Time complexity: O(n^2)
       Space complexity: O(1)
      */
    public int trap(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = i; j >= 0; j--) { // Search the left part for max bar size.
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < size; j++) { // Search the right part for max bar size.
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];  // 按当前列逐步增量
        }
        return ans;
    }
}
