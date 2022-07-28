package Q0699.Q0684RedundantConnection.solution;

public class Solution {
    static class UnionFind {
        int[] id, rank;
        int cnt;

        UnionFind(int _cnt) {
            cnt = _cnt;
            rank = new int[cnt];
            id = new int[cnt];
            for (int i = 0; i < cnt; i++) id[i] = i;
        }

        int find(int p) {
            if (id[p] == p) return p;
            return id[p] = find(id[p]);
        }

        int getCnt() {
            return cnt;
        }

        boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        void connect(int p, int q) {
            int i = find(p), j = find(q);
            if (i == j) return;
            if (rank[i] < rank[j]) id[i] = j;
            else {
                id[j] = i;
                if (rank[i] == rank[j]) rank[j]++;
            }
            --cnt;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for (int[] e : edges) {
            if (uf.connected(e[0] - 1, e[1] - 1)) return e;
            uf.connect(e[0] - 1, e[1] - 1);
        }
        return null;
    }
}