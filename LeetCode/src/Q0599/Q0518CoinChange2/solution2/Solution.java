package Q0599.Q0518CoinChange2.solution2;

public class Solution {
    public int change(int cnt, int[] cs) {
        int n = cs.length;
        int[] f = new int[cnt + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = val; j <= cnt; j++) {
                f[j] += f[j - val];
            }
        }
        return f[cnt];
    }
}