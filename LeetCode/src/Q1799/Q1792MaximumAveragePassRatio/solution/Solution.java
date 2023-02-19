package Q1799.Q1792MaximumAveragePassRatio.solution;

import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> Double.compare((b[0] + 1D) / (b[1] + 1D) - b[0] * 1D / b[1], (a[0] + 1D) / (a[1] + 1D) - a[0] * 1D / a[1])
        );
        for (int[] a : classes) queue.add(a);
        for (int i = 0; i < extraStudents; i++) {
            int[] a = queue.poll();
            queue.add(new int[]{a[0] + 1, a[1] + 1});
        }
        double sum = 0D;
        for (int[] a : queue) sum += 1D * a[0] / a[1];
        return sum / classes.length;
    }
}
