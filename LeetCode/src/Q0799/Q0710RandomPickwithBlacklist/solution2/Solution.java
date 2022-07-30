package Q0799.Q0710RandomPickwithBlacklist.solution2;

import java.util.*;

public class Solution {
    int n, m, idx;
    Random random = new Random();
    Set<Integer> s1 = new HashSet<>(), s2 = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();

    public Solution(int _n, int[] bs) {
        n = _n;
        m = bs.length;
        int max = n - m;
        for (int x : bs) {
            if (x < max) s1.add(x);
            else s2.add(x);
        }
        idx = n - m;
    }

    public int pick() {
        int val = random.nextInt(n - m);
        if (!s1.contains(val)) return val;
        if (!map.containsKey(val)) {
            while (s2.contains(idx)) idx++;
            map.put(val, idx++);
        }
        return map.get(val);
    }
}