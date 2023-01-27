package Q0899.Q0839SimilarStringGroups.solution;

public class Solution {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) uf.union(i, j);
            }
        }
        return uf.getRegions();
    }

    boolean isSimilar(String s1, String s2) {
        int cnt = 0, n = s1.length();
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            if (cs1[i] != cs2[i]) cnt++;
        }
        return cnt == 2 || cnt == 0;
    }

    class UnionFind {
        int[] parent;
        int regions;

        public UnionFind(int n) {
            regions = n;
            parent = new int[n + 1];
        }

        int find(int x) {
            return parent[x] == x ? parent[x] : (parent[x] = find(parent[x]));
        }

        void union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return;
            parent[px] = py;
            regions -= 1;
        }

        int getRegions() {
            return regions;
        }
    }
}
