package Q0699.Q0691StickerstoSpellWord.solution2;

import java.util.Arrays;

public class Solution {
    static int N = 15, INF = 20;
    static int[] f = new int[1 << N];

    public int minStickers(String[] ss, String t) {
        int n = ss.length, m = t.length(), mask = 1 << m;
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int s = 0; s < mask; s++) {
            if (f[s] == INF) continue;
            for (String str : ss) {
                int ns = s, len = str.length();
                for (int i = 0; i < len; i++) {
                    int c = str.charAt(i) - 'a';
                    for (int j = 0; j < m; j++) {
                        if (t.charAt(j) - 'a' == c && (((ns >> j) & 1) == 0)) {
                            ns |= (1 << j);
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