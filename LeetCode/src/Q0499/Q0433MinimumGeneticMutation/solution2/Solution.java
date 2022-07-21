package Q0499.Q0433MinimumGeneticMutation.solution2;

import java.util.*;

public class Solution {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};
    Set<String> set = new HashSet<>();

    public int minMutation(String S, String T, String[] bank) {
        set.add(S);
        for (String s : bank) set.add(s);
        if (!set.contains(T)) return -1;
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        d1.addLast(S);
        d2.addLast(T);
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        m1.put(S, 0);
        m2.put(T, 0);
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) t = update(d1, m1, m2);
            else t = update(d2, m2, m1);
            if (t != -1) return t;
        }
        return -1;
    }

    int update(Deque<String> d, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = d.size();
        while (m-- > 0) {
            String s = d.pollFirst();
            char[] cs = s.toCharArray();
            int step = cur.get(s);
            for (int i = 0; i < 8; i++) {
                for (char c : items) {
                    if (cs[i] == c) continue;
                    char[] clone = cs.clone();
                    clone[i] = c;
                    String sub = String.valueOf(clone);
                    if (!set.contains(sub) || cur.containsKey(sub)) continue;
                    if (other.containsKey(sub)) return other.get(sub) + step + 1;
                    d.addLast(sub);
                    cur.put(sub, step + 1);
                }
            }
        }
        return -1;
    }
}