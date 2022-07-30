package Q0799.Q0703KthLargestElementinaStream.solution3;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> queue;

    public KthLargest(int _k, int[] _nums) {
        k = _k;
        queue = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));
        int n = _nums.length;
        for (int i = 0; i < k && i < n; i++) queue.add(_nums[i]);
        for (int i = k; i < n; i++) add(_nums[i]);
    }

    public int add(int val) {
        int t = !queue.isEmpty() ? queue.peek() : Integer.MIN_VALUE;
        if (val > t || queue.size() < k) {
            if (!queue.isEmpty() && queue.size() >= k) queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}