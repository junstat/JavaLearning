package Q0899.Q0846HandofStraights.solution1;

import java.util.TreeMap;

public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        var c = new TreeMap<Integer, Integer>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0) + 1);
        for (int it : c.keySet()) {
            if (c.get(it) > 0)
                for (int i = W - 1; i >= 0; i--) {
                    if (c.getOrDefault(it + i, 0) < c.get(it)) return false;
                    c.put(it + i, c.get(it + i) - c.get(it));
                }
        }
        return true;
    }
}
