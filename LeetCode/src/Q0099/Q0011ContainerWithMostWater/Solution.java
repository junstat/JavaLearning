package Q0099.Q0011ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int volume = 0;
        while (left < right) {
            volume = Math.max(volume, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return volume;
    }
}
