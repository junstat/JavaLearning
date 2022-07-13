package Q0399.Q0375GuessNumberHigherorLowerII.solution3;

public class Solution {
    static int N = 200;
    static int[][] f = new int[N + 10][N + 10];

    static {
        for (int len = 2; len <= N; len++) {
            for (int l = 1; l + len - 1 <= N; l++) {
                int r = l + len - 1;
                f[l][r] = 0x3f3f3f3f;
                for (int x = l; x <= r; x++) {
                    int cur = Math.max(f[l][x - 1], f[x + 1][r]) + x;
                    f[l][r] = Math.min(f[l][r], cur);
                }
            }
        }
    }

    public int getMoneyAmount(int n) {
        return f[1][n];
    }
}