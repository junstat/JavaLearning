package Q1699.Q1632RankTransformofaMatrix.solution;

import java.util.*;

public class Solution {

    class UnionFind {
        Map<Integer, Integer> parent = new HashMap<>();

        int find(int u) {
            if (u == parent.getOrDefault(u, -1)) return u;
            parent.put(u, find(parent.get(u)));
            return parent.get(u);
        }

        void union(int u, int v) {
            if (!parent.containsKey(u)) parent.put(u, u);
            if (!parent.containsKey(v)) parent.put(v, v);
            int pu = find(u), pv = find(v);
            if (pu != pv) parent.put(pu, pv);
        }

        Map<Integer, List<Integer>> getGroups() {
            Map<Integer, List<Integer>> groups = new HashMap<>();
            for (int u : parent.keySet()) {
                int pu = find(u);
                groups.putIfAbsent(pu, new ArrayList<>());
                groups.get(pu).add(u);
            }
            return groups;
        }
    }

    public int[][] matrixRankTransform(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<Integer, List<int[]>> groupByValue = new HashMap<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int elem = matrix[r][c];
                groupByValue.putIfAbsent(elem, new ArrayList<>());
                groupByValue.get(elem).add(new int[]{r, c});
            }
        }
        int[] rank = new int[m + n];
        for (List<int[]> cells : groupByValue.values()) {
            UnionFind uf = new UnionFind();
            for (int[] cell : cells) {
                int r = cell[0], c = cell[1];
                uf.union(r, c + m);
            }
            for (List<Integer> group : uf.getGroups().values()) {
                int maxRank = 0;
                for (int i : group) maxRank = Math.max(maxRank, rank[i]);
                for (int i : group) rank[i] = maxRank + 1;
            }
            for (int[] cell : cells) {
                int r = cell[0], c = cell[1];
                matrix[r][c] = rank[r];
            }
        }
        return matrix;
    }
}
