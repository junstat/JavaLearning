package Q0399.Q0327CountofRangeSum.solution4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    class Node {
        int ls = -1, rs = -1, val = 0;
    }
    List<Node> tr = new ArrayList<>();
    void update(int u, long lc, long rc, long x, int v) {
        Node node = tr.get(u);
        node.val += v;
        if (lc == rc) return ;
        long mid = lc + rc >> 1;
        if (x <= mid) {
            if (node.ls == -1) {
                tr.add(new Node());
                node.ls = tr.size() - 1;
            }
            update(node.ls, lc, mid, x, v);
        } else {
            if (node.rs == -1) {
                tr.add(new Node());
                node.rs = tr.size() - 1;
            }
            update(node.rs, mid + 1, rc, x, v);
        }
    }
    int query(int u, long lc, long rc, long l, long r) {
        if (u == -1) return 0;
        if (r < lc || l > rc) return 0;
        Node node = tr.get(u);
        if (l <= lc && rc <= r) return node.val;
        long mid = lc + rc >> 1;
        return query(node.ls, lc, mid, l, r) + query(node.rs, mid + 1, rc, l, r);
    }
    public int countRangeSum(int[] nums, int lower, int upper) {
        long L = 0, R = 0, s = 0;
        for (int i : nums) {
            s += i;
            L = Math.min(Math.min(L, s), Math.min(s - lower, s - upper));
            R = Math.max(Math.max(R, s), Math.max(s - lower, s - upper));
        }
        s = 0;
        int ans = 0;
        tr.add(new Node());
        update(0, L, R, 0, 1);
        for (int i : nums) {
            s += i;
            long a = s - upper, b = s - lower;
            ans += query(0, L, R, a, b);
            update(0, L, R, s, 1);
        }
        return ans;
    }
}