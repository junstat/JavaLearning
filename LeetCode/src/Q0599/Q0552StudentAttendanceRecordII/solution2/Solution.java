package Q0599.Q0552StudentAttendanceRecordII.solution2;

// 从 f[u][acnt][lcnt] 往回找所依赖的状态
public class Solution {
    int mod = (int) 1e9 + 7;

    public int checkRecord(int n) {
        int[][][] f = new int[n + 1][2][3];
        f[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == 1 && k == 0) { // A
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][0]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][1]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j - 1][2]) % mod;
                    }
                    if (k != 0) { // L
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][k - 1]) % mod;
                    }
                    if (k == 0) { // P
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][0]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][1]) % mod;
                        f[i][j][k] = (f[i][j][k] + f[i - 1][j][2]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                ans += f[n][j][k];
                ans %= mod;
            }
        }
        return ans;
    }
}