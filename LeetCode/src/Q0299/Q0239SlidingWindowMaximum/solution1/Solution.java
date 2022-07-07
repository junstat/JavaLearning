package Q0299.Q0239SlidingWindowMaximum.solution1;

import java.util.PriorityQueue;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]));
        for (int i = 0; i < k; i++) pq.offer(new int[]{nums[i], i});
        int[] result = new int[n - k + 1];
        result[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) pq.poll();
            result[i - k + 1] = pq.peek()[0];
        }
        return result;
    }
}
