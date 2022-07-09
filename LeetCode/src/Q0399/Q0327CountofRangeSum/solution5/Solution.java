package Q0399.Q0327CountofRangeSum.solution5;

public class Solution {
    class Node {
        Node ls, rs;
        int val = 0;
    }

    void update(Node node, long lc, long rc, long x, int v) {
        node.val += v;
        if (lc == rc) return;
        long mid = lc + rc >> 1;
        if (x <= mid) {
            if (node.ls == null) node.ls = new Node();
            update(node.ls, lc, mid, x, v);
        } else {
            if (node.rs == null) node.rs = new Node();
            update(node.rs, mid + 1, rc, x, v);
        }
    }

    int query(Node node, long lc, long rc, long l, long r) {
        if (node == null) return 0;
        if (r < lc || l > rc) return 0;
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
        Node root = new Node();
        update(root, L, R, 0, 1);
        for (int i : nums) {
            s += i;
            long a = s - upper, b = s - lower;
            ans += query(root, L, R, a, b);
            update(root, L, R, s, 1);
        }
        return ans;
    }
}