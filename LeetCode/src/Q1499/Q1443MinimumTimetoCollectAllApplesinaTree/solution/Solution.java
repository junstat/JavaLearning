package Q1499.Q1443MinimumTimetoCollectAllApplesinaTree.solution;

import java.util.*;

public class Solution {
    int ans = 0;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (edges == null || edges.length == 0) return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.putIfAbsent(edge[0], new ArrayList<>());
            graph.putIfAbsent(edge[1], new ArrayList<>());
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0, graph, hasApple, new HashSet<>());
        return ans;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> graph, List<Boolean> hasApple, Set<Integer> seen) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int next : graph.get(node)) {
            if (dfs(next, graph, hasApple, seen)) {
                hasApple.set(node, true);
                ans += 2;
            }
        }
        seen.remove(node);
        return hasApple.get(node);
    }
}