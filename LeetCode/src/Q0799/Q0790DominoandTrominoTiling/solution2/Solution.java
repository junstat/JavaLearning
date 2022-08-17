package Q0799.Q0790DominoandTrominoTiling.solution2;

public class Solution {
    public int numTilings(int n) {
        long mod = (int) 1e9 + 7, dp11 = 1, dp12 = 0, dp22 = 0;
        for (int i = 1; i <= n; i++) {
            long dp00 = (dp11 + dp22 + dp12 * 2) % mod;
            long dp01 = (dp22 + dp12) % mod;
            dp22 = dp11;
            dp11 = dp00;
            dp12 = dp01;
        }
        return (int) dp11;
    }
}
