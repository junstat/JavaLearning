package Q2899.Q2866;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(-1);
        long ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && maxHeights.get(stack.peekLast()) > maxHeights.get(i)) {
                int j = stack.pollLast();
                cur -= (long) (j - stack.peekLast()) * maxHeights.get(j);
            }
            cur += (long) (i - stack.peekLast()) * maxHeights.get(i);
            stack.addLast(i);
            left[i] = cur;
        }
        stack.clear();
        stack.addLast(n);
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && maxHeights.get(stack.peekLast()) > maxHeights.get(i)) {
                int j = stack.pollLast();
                cur -= (long) -(j - stack.peekLast()) * maxHeights.get(j);
            }
            cur += (long) -(i - stack.peekLast()) * maxHeights.get(i);
            stack.addLast(i);
            ans = Math.max(ans, left[i] + cur - maxHeights.get(i));
        }
        return ans;
    }
}
