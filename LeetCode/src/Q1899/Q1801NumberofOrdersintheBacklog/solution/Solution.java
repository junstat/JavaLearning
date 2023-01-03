package Q1899.Q1801NumberofOrdersintheBacklog.solution;

import java.util.PriorityQueue;

public class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> b[0] - a[0]), sell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> from = null, to = null;
        boolean fromIsSell = false;
        for (int[] order : orders) {
            int p = order[0], a = order[1], t = order[2];
            if (t == 0) {
                from = sell;
                to = buy;
                fromIsSell = true;
            } else {
                from = buy;
                to = sell;
                fromIsSell = false;
            }
            while (a > 0 && !from.isEmpty() && (fromIsSell ? from.peek()[0] <= p : from.peek()[0] >= p)) {
                int[] cur = from.poll();
                int cnt = Math.min(cur[1], a);
                cur[1] -= cnt;
                a -= cnt;
                if (cur[1] > 0) from.add(cur);
            }
            if (a > 0) to.add(new int[]{p, a});
        }
        int ans = 0;
        for (PriorityQueue<int[]> q : new PriorityQueue[]{buy, sell}) {
            while (!q.isEmpty()) {
                ans += q.poll()[1];
                ans %= (int) 1e9 + 7;
            }
        }
        return ans;
    }
}