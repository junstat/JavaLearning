package Q1399.Q1376TimeNeededtoInformAllEmployees.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, List<Integer>> graph;
    int[] informTime;

    public int numOfMinutes(int n, int headID, int[] manager, int[] _informTime) {
        informTime = _informTime;
        graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int j = manager[i];
            if (!graph.containsKey(j)) graph.put(j, new ArrayList<>());
            graph.get(j).add(i);
        }
        return dfs(headID);
    }

    int dfs(int u) {
        int max = 0;
        if (!graph.containsKey(u)) return max;
        for (int i = 0; i < graph.get(u).size(); i++)
            max = Math.max(max, dfs(graph.get(u).get(i)));
        return max + informTime[u];
    }
}
