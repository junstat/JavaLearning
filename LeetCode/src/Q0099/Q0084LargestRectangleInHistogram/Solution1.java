package Q0099.Q0084LargestRectangleInHistogram;

public class Solution1 {
    /*
      方法1： 暴力方法(Time Limit Exceeded)
       - 面积 = 底 x 高
       - 固定底，求最大高度不好求
       - 固定高，求最长底边好求
       - 从i向两边遍历，找到左边和右边第1个严格小于height[i]的时候停下，中间的长度就是最长底边
       时间复杂度度: O(n^2)，空间复杂度: O(1)
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int ans = 0;
        for (int cur = 0; cur < len; cur++) { // 枚举高
            int height = heights[cur];
            int left = cur, right = cur;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < len && heights[right + 1] >= height) {
                ++right;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }
}
