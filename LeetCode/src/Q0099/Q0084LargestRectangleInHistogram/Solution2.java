package Q0099.Q0084LargestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    /*
      方法2: 单调栈
      area of rectangle include heights[i] is:
      (index of nextSmaller - index of previousSmaller - 1) * heights[i]

      回顾方法1，用数组遍历的视角来看
        left是指前一个小于当前高度的下标(index of previousSmaller)
        right是指下一个小于当前高度的下标(index of nextSmaller)
    */
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