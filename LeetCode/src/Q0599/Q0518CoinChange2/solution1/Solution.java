package Q0599.Q0518CoinChange2.solution1;

public class Solution {
    public int change(int cnt, int[] cs) {
        int n = cs.length;
        int[][] f = new int[n + 1][cnt + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = cs[i - 1];
            for (int j = 0; j <= cnt; j++) {
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * val <= j; k++) {
                    f[i][j] += f[i - 1][j - k * val];
                }
            }
        }
        return f[n][cnt];
    }
}