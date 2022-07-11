package Q0599.Q0547NumberofProvinces.solution1;

public class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) if (M[i][j] != 0) uf.connect(i, j);
        }
        return uf.getCount();
    }

    class UnionFind {
        int[] rank;
        int[] id;
        int count;

        public UnionFind(int n) {
            rank = new int[n];
            id = new int[n];
            count = n;
            for (int i = 0; i < n; i++) id[i] = i;
        }

        int find(int i) {
            if (id[i] == i) return i;
            return id[i] = find(id[i]);
        }

        void connect(int i, int j) {
            int p = find(i), q = find(j);
            if (p == q) return;
            if (rank[p] > rank[q]) id[p] = q;
            else {
                id[q] = p;
                if (rank[p] == rank[q]) rank[p]++;
            }
            --count;
        }

        int getCount() {
            return count;
        }
    }
}

