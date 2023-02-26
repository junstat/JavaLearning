package Q1699.Q1675MinimizeDeviationinArray.solution1;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    static int MAX = Integer.MAX_VALUE;

    public int minimumDeviation(int[] nums) {
        int ans = MAX, min = MAX;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            num = (num & 1) == 1 ? num * 2 : num;
            pq.offer(num);
            min = Math.min(min, num);
        }
        while ((pq.peek() & 1) == 0) {
            ans = Math.min(ans, pq.peek() - min);
            min = Math.min(min, pq.peek() / 2);
            pq.offer(pq.peek() / 2);
            pq.poll();
        }
        return Math.min(ans, pq.peek() - min);
    }
}