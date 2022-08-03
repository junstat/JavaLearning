package Q0099.Q0085MaximalRectangle.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (char[] chars : matrix) {
            for (int i = 0; i < n; i++) {
                if (chars[i] == '1') heights[i]++;
                else heights[i] = 0;
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> d = new ArrayDeque<>();
        int ans = 0;
        for (int r = 0; r <= n; r++) {
            int h = (r == n ? 0 : heights[r]);
            if (d.isEmpty() || h >= heights[d.peekLast()]) d.addLast(r);
            else {
                int cur = d.pollLast();
                int l = d.isEmpty() ? -1 : d.peekLast();
                int w = r - l - 1;
                ans = Math.max(ans, heights[cur] * w);
                r--;
            }
        }
        return ans;
    }
}