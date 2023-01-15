package Q0899.Q0835ImageOverlap.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        List<Integer> LA = new ArrayList<>(), LB = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n * n; ++i)
            if (A[i / n][i % n] == 1)
                LA.add(i / n * 100 + i % n);
        for (int i = 0; i < n * n; ++i)
            if (B[i / n][i % n] == 1)
                LB.add(i / n * 100 + i % n);
        for (int i : LA)
            for (int j : LB)
                map.put(i - j, map.getOrDefault(i - j, 0) + 1);
        int ans = 0;
        for (int i : map.values()) {
            ans = Math.max(ans, i);
        }
        return ans;
    }
}
