package Q1899.Q1817FindingtheUsersActiveMinutes.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        int[] ans = new int[k];
        for (int[] l : logs) {
            m.putIfAbsent(l[0], new HashSet<>());
            m.get(l[0]).add(l[1]);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : m.entrySet()) {
            ans[entry.getValue().size() - 1]++;
        }
        return ans;
    }
}