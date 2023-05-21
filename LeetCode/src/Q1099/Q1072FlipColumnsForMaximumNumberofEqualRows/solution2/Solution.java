package Q1099.Q1072FlipColumnsForMaximumNumberofEqualRows.solution2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix[0].length, ans = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int[] ints : matrix) {
            long key = 0;
            for (int j = 0; j < m; j++) key = key * 233 + (ints[j] ^ ints[0]);
            int v = map.getOrDefault(key, 0) + 1;
            ans = Math.max(ans, v);
            map.put(key, v);
        }
        return ans;
    }
}
