package Q0699.Q0672BulbSwitcherII.solution;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int flipLights(int n, int m) {
        Set<Integer> seen = new HashSet<>();
        n = Math.min(n, 6);
        int shift = 6 - n;
        for (int i = 0; i < 16; i++) {
            int cnt = Integer.bitCount(i);
            if (cnt % 2 == m % 2 && cnt <= m) {
                int lights = 0;
                if (((i >> 0) & 1) == 1) lights ^= 0b111111 >> shift;
                if (((i >> 1) & 1) == 1) lights ^= 0b010101 >> shift;
                if (((i >> 2) & 1) == 1) lights ^= 0b101010 >> shift;
                if (((i >> 3) & 1) == 1) lights ^= 0b100100 >> shift;
                seen.add(lights);
            }
        }
        return seen.size();
    }
}