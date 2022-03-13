package Q0499.Q0403FrogJump;

import java.util.HashMap;
import java.util.Map;

/*
    Search for the last stone in a depth-first way, prune those exceeding the [k-1,k+1] range.
 */
public class Solution {
    private Map<Integer, Boolean> dp = new HashMap<>();

    public boolean canCross(int[] stones) {
        return canCross(stones, 0, 0);
    }

    public boolean canCross(int[] stones, int pos, int k) {
        int key = pos | k << 11;
        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = pos + 1; i < stones.length; i++) {
            int gap = stones[i] - stones[pos];
            if (gap < k - 1) continue;
            if (gap > k + 1) {
                dp.put(key, false);
                return false;
            }
            if (canCross(stones, i, gap)) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, pos == stones.length - 1);
        return dp.get(key);
    }
}
