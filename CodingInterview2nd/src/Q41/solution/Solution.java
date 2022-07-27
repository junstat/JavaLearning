package Q41.solution;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> large = new PriorityQueue<>();
    boolean even = true;

    public void Insert(Integer num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public Double GetMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else return small.peek() * 1.0;
    }
}