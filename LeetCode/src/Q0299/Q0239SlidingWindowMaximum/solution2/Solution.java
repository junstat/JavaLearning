package Q0299.Q0239SlidingWindowMaximum.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!d.isEmpty() && nums[i] >= nums[d.peekLast()])
                d.pollLast();
            d.addLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[d.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!d.isEmpty() && nums[i] >= nums[d.peekLast()])
                d.pollLast();
            d.addLast(i);
            while (d.peekFirst() <= i - k) d.pollFirst();
            ans[i - k + 1] = nums[d.peekFirst()];
        }
        return ans;
    }
}