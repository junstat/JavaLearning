package Q0299.Q0215KthLargestElementinanArray;

import java.util.PriorityQueue;

// priority queue
public class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) q.poll();
        }
        return q.peek();
    }
}
