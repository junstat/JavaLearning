package Q0699.Q0691StickerstoSpellWord.solution3;

import java.util.*;

public class Solution {
    static int N = 15, INF = 20;
    static int[] f = new int[1 << N];
    public int minStickers(String[] ss, String t) {
        int n = ss.length, m = t.length(), mask = 1 << m;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = ss[i];
            for (char c : str.toCharArray()) {
                int d = c - 'a';
                List<Integer> list = map.getOrDefault(d, new ArrayList<>());
                if (list.size() == 0 || list.get(list.size() - 1) != i) list.add(i);
                map.put(d, list);
            }
        }
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int s = 0; s < mask; s++) {
            if (f[s] == INF) continue;
            int loc = -1;
            for (int i = 0; i < m && loc == -1; i++) {
                if (((s >> i) & 1) == 0) loc = i;
            }
            if (loc == -1) continue;
            List<Integer> list = map.getOrDefault(t.charAt(loc) - 'a', new ArrayList<>());
            for (int i = 0; i < list.size(); i++) {
                String str = ss[list.get(i)];
                int ns = s, len = str.length();
                for (int j = 0; j < len; j++) {
                    char c = str.charAt(j);
                    for (int k = 0; k < m; k++) {
                        if (t.charAt(k) == c && (((ns >> k) & 1) == 0)) {
                            ns |= (1 << k);
                            break;
                        }
                    }
                }
                f[ns] = Math.min(f[ns], f[s] + 1);
            }
        }
        return f[mask - 1] == INF ? -1 : f[mask - 1];
    }
}