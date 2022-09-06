package Q0799.Q0797AllPathsFromSourcetoTarget.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[][] g;
    int n;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        g = graph;
        n = g.length;
        cur.add(0);
        dfs(0);
        return ans;
    }

    void dfs(int u) {
        if (u == n - 1) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int next : g[u]) {
            cur.add(next);
            dfs(next);
            cur.remove(cur.size() - 1);
        }
    }
}