package Q1099.Q1061LexicographicallySmallestEquivalentString.solution;

import java.util.Arrays;

public class Solution {
    int[] par = new int[26];

    int find(int x) {
        if (par[x] == -1) return x;
        return par[x] = find(par[x]);
    }

    void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            par[Math.max(x, y)] = Math.min(x, y);
    }

    public String smallestEquivalentString(String ss1, String ss2, String baseStr) {
        Arrays.fill(par, -1);
        char[] s1 = ss1.toCharArray();
        char[] s2 = ss2.toCharArray();
        char[] bs = baseStr.toCharArray();
        char[] ans = new char[baseStr.length()];
        int n = s1.length;
        for (int i = 0; i < n; i++) union(s1[i] - 'a', s2[i] - 'a');
        for (int i = 0; i < baseStr.length(); i++) {
            ans[i] = (char) (find(bs[i] - 'a') + 'a');
        }
        return new String(ans);
    }
}
