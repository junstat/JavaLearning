package Q0099.Q0084LargestRectangleInHistogram.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int largestRectangleArea(int[] heights) {
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