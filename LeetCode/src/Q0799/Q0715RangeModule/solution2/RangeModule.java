package Q0799.Q0715RangeModule.solution2;

public class RangeModule {
    class Node {
        Node ls, rs;
        int sum, add;
    }

    int N = (int) 1e9 + 10;
    Node root = new Node();

    void update(Node node, int lc, int rc, int l, int r, int v) {
        int len = rc - lc + 1;
        if (l <= lc && rc <= r) {
            node.sum = v == 1 ? len : 0;
            node.add = v;
            return;
        }
        pushdown(node, len);
        int mid = lc + rc >> 1;
        if (l <= mid) update(node.ls, lc, mid, l, r, v);
        if (r > mid) update(node.rs, mid + 1, rc, l, r, v);
        pushup(node);
    }

    int query(Node node, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return node.sum;
        pushdown(node, rc - lc + 1);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = query(node.ls, lc, mid, l, r);
        if (r > mid) ans += query(node.rs, mid + 1, rc, l, r);
        return ans;
    }

    void pushdown(Node node, int len) {
        if (node.ls == null) node.ls = new Node();
        if (node.rs == null) node.rs = new Node();
        if (node.add == 0) return;
        int add = node.add;
        if (add == -1) {
            node.ls.sum = node.rs.sum = 0;
        } else {
            node.ls.sum = len - len / 2;
            node.rs.sum = len / 2;
        }
        node.ls.add = node.rs.add = add;
        node.add = 0;
    }

    void pushup(Node node) {
        node.sum = node.ls.sum + node.rs.sum;
    }

    public void addRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, 1);
    }

    public boolean queryRange(int left, int right) {
        return query(root, 1, N - 1, left, right - 1) == right - left;
    }

    public void removeRange(int left, int right) {
        update(root, 1, N - 1, left, right - 1, -1);
    }
}