package Q0099.Q0042TrappingRainWater;

public class Solution5 {
    /*
      Keep track of the already safe level and the total water so far.
      In each step, process and discard the lower one of the leftmost
      or rightmost elevation.
      time complexity: O(n)
      space complexity: O(1)
     */
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, level = 0, water = 0;
        while (l < r) {
            int lower = height[height[l] < height[r] ? l++ : r--];
            level = Math.max(level, lower);
            water += level - lower;
        }
        return water;
    }
}
