package Q0799.Q0785IsGraphBipartite.solution1;

public class Solution {
    int[][] g;
    int n;
    int[] id;   // 0 -> unseen, 1 and -1 are different colors

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        id = new int[n];
        g = graph;
        for (int i = 0; i < n; i++) {
            if (id[i] == 0 && !dfs(i, 1)) return false;
        }
        return true;
    }

    boolean dfs(int u, int color) {
        if (id[u] == 1) return id[u] == color;
        id[u] = color;
        for (int v : g[u]) {
            if (!dfs(v, -color)) return false;
        }
        return true;
    }
}