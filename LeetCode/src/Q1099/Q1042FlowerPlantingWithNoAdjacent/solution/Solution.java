package Q1099.Q1042FlowerPlantingWithNoAdjacent.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        Map<Integer, Set<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) g.put(i, new HashSet<>());
        for (int[] p : paths) {
            g.get(p[0] - 1).add(p[1] - 1);
            g.get(p[1] - 1).add(p[0] - 1);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] colors = new int[5];
            for (int j : g.get(i)) colors[ans[j]] = 1;
            for (int c = 4; c > 0; --c)
                if (colors[c] == 0) ans[i] = c;
        }
        return ans;
    }
}