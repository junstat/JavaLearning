package Q0999.Q0970PowerfulIntegers.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();
        for (int a = 1; a < bound; a *= x) {
            for (int b = 1; a + b <= bound; b *= y) {
                ans.add(a + b);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(ans);
    }
}