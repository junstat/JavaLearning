package Q0299.Q0239SlidingWindowMaximum.solution2;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
        }
        int[] result = new int[n - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) deque.pollFirst();
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
