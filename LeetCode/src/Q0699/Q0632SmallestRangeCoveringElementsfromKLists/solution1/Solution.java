package Q0699.Q0632SmallestRangeCoveringElementsfromKLists.solution1;

import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    static int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        int min = MAX, max = MIN;
        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }
        int range = MAX, start = -1, end = -1;
        while (pq.size() == nums.size()) {
            Element cur = pq.poll();
            if (max - cur.val < range) {
                range = max - cur.val;
                start = cur.val;
                end = max;
            }
            if (cur.idx + 1 < nums.get(cur.row).size()) {
                cur.idx = cur.idx + 1;
                cur.val = nums.get(cur.row).get(cur.idx);
                pq.offer(cur);
                if (cur.val > max) max = cur.val;
            }
        }
        return new int[]{start, end};
    }

    static class Element {
        int val, idx, row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }
}
