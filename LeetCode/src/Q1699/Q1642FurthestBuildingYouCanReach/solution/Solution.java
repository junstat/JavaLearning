package Q1699.Q1642FurthestBuildingYouCanReach.solution;

import java.util.PriorityQueue;

public class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sumH = 0;
        for (int i = 1; i < n; i++) {
            int deltaH = heights[i] - heights[i - 1];
            if (deltaH > 0) {
                q.add(deltaH);
                if (q.size() > ladders) sumH += q.poll();
                if (sumH > bricks) return i - 1;
            }
        }
        return n - 1;
    }
}
