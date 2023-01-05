package Q1899.Q1803CountPairsWithXORinaRange.solution2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countPairs(int[] A, int low, int high) {
        return test(A, high + 1) - test(A, low);
    }

    private int test(int[] A, int x) {
        Map<Integer, Integer> count = new HashMap<>(), count2 = new HashMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        int res = 0;
        while (x > 0) {
            for (int k : count.keySet()) {
                int v = count.get(k);
                count2.put(k >> 1, count2.getOrDefault(k >> 1, 0) + v);
                if ((x & 1) > 0)
                    res += v * count.getOrDefault((x - 1) ^ k, 0);
            }
            count = count2;
            count2 = new HashMap<>();
            x >>= 1;
        }
        return res / 2;
    }
}