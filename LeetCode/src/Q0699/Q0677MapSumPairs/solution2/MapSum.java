package Q0699.Q0677MapSumPairs.solution2;

import java.util.Arrays;

public class MapSum {
    static int[][] tr = new int[2510][26];
    static int[] hash = new int[2510];
    static int idx;

    public MapSum() {
        for (int i = 0; i <= idx; i++) Arrays.fill(tr[i], 0);
        Arrays.fill(hash, 0);
        idx = 0;
    }

    public void insert(String key, int val) {
        int p = 0;
        for (int i = 0; i < key.length(); i++) {
            int u = key.charAt(i) - 'a';
            if (tr[p][u] == 0) tr[p][u] = ++idx;
            p = tr[p][u];
        }
        hash[p] = val;
    }

    public int sum(String prefix) {
        int p = 0;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (tr[p][u] == 0) return 0;
            p = tr[p][u];
        }
        return dfs(p);
    }

    int dfs(int p) {
        int ans = hash[p];
        for (int u = 0; u < 26; u++) {
            if (tr[p][u] != 0) ans += dfs(tr[p][u]);
        }
        return ans;
    }
}