package Q1999.Q1944;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] <= heights[i])
                ans[stack.pollLast()]++;
            if (!stack.isEmpty())
                ans[stack.peekLast()]++;
            stack.addLast(i);
        }
        return ans;
    }
}
