package Q0399.Q0318MaximumProductofWordLengths.solution2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int t = 0, m = w.length();
            for (int i = 0; i < m; i++) {
                int u = w.charAt(i) - 'a';
                t |= (1 << u);
            }
            if (!map.containsKey(t) || map.get(t) < m) map.put(t, m);
        }
        int ans = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0) ans = Math.max(ans, map.get(a) * map.get(b));
            }
        }
        return ans;
    }
}