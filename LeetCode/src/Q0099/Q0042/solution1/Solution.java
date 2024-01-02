package Q0099.Q0042.solution1;

public class Solution {
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
