package Q0099.Q0085MaximalRectangle.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

/*
   以 example 1. 为例
    matrix = [
      ["1","0","1","0","0"],
      ["1","0","1","1","1"],
      ["1","1","1","1","1"],
      ["1","0","0","1","0"]
    ]

    分析: 遍历 行(row)
    row = 1: 可以得到 heights = [1, 0, 1, 0, 0] 套用 Q84
    row = 2: -> heights = [2, 0, 2, 1, 1]
    ......
  */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int col = matrix[0].length;
        int[] heights = new int[col];
        int max = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < col; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);
            max = Math.max(max, area);
        }
        return max;
    }

    // 来自 Q84
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        Deque<Integer> s = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++) {
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                int width = (s.isEmpty() ? i : i - 1 - s.peek());
                maxArea = Math.max(maxArea, heights[tp] * width);
                i--;
            }
        }
        return maxArea;
    }
}
