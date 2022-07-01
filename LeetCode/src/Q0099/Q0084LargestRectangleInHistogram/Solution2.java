package Q0099.Q0084LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> d = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            if (d.isEmpty() || h >= heights[d.peek()]) {
                d.push(i);
            } else {
                int top = d.pop();
                int w = (d.isEmpty() ? i : i - 1 - d.peek());
                ans = Math.max(ans, heights[top] * w);
                i--;
            }
        }
        return ans;
    }
}

/*
   单调栈(Monotone Stack)
    - 单调栈首先是栈，是栈的应用
    - 栈内元素维持了"单调性"的应用场景
      1. 单调递增(不减)栈可以找到左边第一个比当前出栈元素小(包含等于)的元素
      2. 单调递减(不增)栈可以找到左边第一个比当前出栈元素大(包含等于)的元素

   练习:
    42
    739
    496
    316
    901
    402
    581
  */