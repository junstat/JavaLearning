package Q0399.Q0352DataStreamasDisjointIntervals.solution3;

import java.util.Iterator;
import java.util.TreeSet;

public class SummaryRanges {
    TreeSet<int[]> ts = new TreeSet<>((a, b) -> a[0] - b[0]);
    int[] head = new int[]{-10, -10}, tail = new int[]{10010, 10010};

    public SummaryRanges() {
        ts.add(head);
        ts.add(tail);
    }

    public void addNum(int val) {
        int[] cur = new int[]{val, val};
        int[] prev = ts.floor(cur);
        int[] next = ts.ceiling(cur);
        if ((prev[0] <= val && val <= prev[1]) || (next[0] <= val && val <= next[1])) {
            // pass
        } else if (prev[1] + 1 == val && next[0] - 1 == val) {
            prev[1] = next[1];
            ts.remove(next);
        } else if (prev[1] + 1 == val) {
            prev[1] = val;
        } else if (next[0] - 1 == val) {
            next[0] = val;
        } else {
            ts.add(cur);
        }
    }

    public int[][] getIntervals() {
        // using ceiling
        // int n = ts.size();
        // int[][] ans = new int[n - 2][2];
        // int[] cur = head;
        // for (int i = 0; i < n - 2; i++) {
        //     ans[i] = ts.ceiling(new int[]{cur[0] + 1, cur[1] + 1});
        //     cur = ans[i];
        // }
        // return ans;

        // using iterator
        int n = ts.size();
        int[][] ans = new int[n - 2][2];
        Iterator<int[]> iterator = ts.iterator();
        iterator.next();
        for (int i = 0; i < n - 2; i++) ans[i] = iterator.next();
        return ans;
    }
}
