package Q0799.Q0731MyCalendarII.solution;

public class MyCalendarTwo {
    class Node {
        // ls 和 rs 分别代表当前节点的左右子节点在 tr 的下标
        // add 为懒标记
        // max 为当前区间的最大值
        int ls, rs, add, max;
    }

    int N = (int) 1e9, M = 1000010, cnt = 1;
    Node[] tr = new Node[M];

    void update(int u, int lc, int rc, int l, int r, int v) {
        if (l <= lc && rc <= r) {
            tr[u].add += v;
            tr[u].max += v;
            return;
        }
        lazyCreate(u);
        pushdown(u);
        int mid = lc + rc >> 1;
        if (l <= mid) update(tr[u].ls, lc, mid, l, r, v);
        if (r > mid) update(tr[u].rs, mid + 1, rc, l, r, v);
        pushup(u);
    }

    int query(int u, int lc, int rc, int l, int r) {
        if (l <= lc && rc <= r) return tr[u].max;
        lazyCreate(u);
        pushdown(u);
        int mid = lc + rc >> 1, ans = 0;
        if (l <= mid) ans = Math.max(ans, query(tr[u].ls, lc, mid, l, r));
        if (r > mid) ans = Math.max(ans, query(tr[u].rs, mid + 1, rc, l, r));
        return ans;
    }

    void lazyCreate(int u) {
        if (tr[u] == null) tr[u] = new Node();
        if (tr[u].ls == 0) {
            tr[u].ls = ++cnt;
            tr[tr[u].ls] = new Node();
        }
        if (tr[u].rs == 0) {
            tr[u].rs = ++cnt;
            tr[tr[u].rs] = new Node();
        }
    }

    void pushup(int u) {
        tr[u].max = Math.max(tr[tr[u].ls].max, tr[tr[u].rs].max);
    }

    void pushdown(int u) {
        tr[tr[u].ls].add += tr[u].add;
        tr[tr[u].rs].add += tr[u].add;
        tr[tr[u].ls].max += tr[u].add;
        tr[tr[u].rs].max += tr[u].add;
        tr[u].add = 0;
    }

    public boolean book(int start, int end) {
        if (query(1, 1, N + 1, start + 1, end) >= 2) return false;
        update(1, 1, N + 1, start + 1, end, 1);
        return true;
    }
}