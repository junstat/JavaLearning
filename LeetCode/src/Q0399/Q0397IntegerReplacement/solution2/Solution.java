package Q0399.Q0397IntegerReplacement.solution2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        Map<Long, Integer> map = new HashMap<>();
        Deque<Long> d = new ArrayDeque<>();
        d.addLast(n * 1L);
        map.put(n * 1L, 0);
        while (!d.isEmpty()) {
            long t = d.pollFirst();
            int step = map.get(t);
            long[] ns = t % 2 == 0 ? new long[]{t / 2} : new long[]{t + 1, t - 1};
            for (long x : ns) {
                if (x == 1) return step + 1;
                if (!map.containsKey(x)) {
                    map.put(x, step + 1);
                    d.addLast(x);
                }
            }
        }
        return -1;
    }
}
