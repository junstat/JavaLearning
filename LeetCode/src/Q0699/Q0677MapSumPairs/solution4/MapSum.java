package Q0699.Q0677MapSumPairs.solution4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MapSum {
    static int N = 2510;
    static int[][] tr = new int[N][26];
    static int[] hash = new int[N];
    static int idx;
    static Map<String, Integer> map = new HashMap<>();

    public MapSum() {
        for (int i = 0; i <= idx; i++) Arrays.fill(tr[i], 0);
        Arrays.fill(hash, 0);
        idx = 0;
        map.clear();
    }

    public void insert(String key, int val) {
        int _val = val;
        if (map.containsKey(key)) val -= map.get(key);
        map.put(key, _val);
        for (int i = 0, p = 0; i < key.length(); i++) {
            int u = key.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
            hash[p] += val;
        }
    }

    public int sum(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (tr[p][u] == 0) return 0;
            p = tr[p][u];
        }
        return hash[p];
    }
}