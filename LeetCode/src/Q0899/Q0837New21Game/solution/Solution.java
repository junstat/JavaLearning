package Q0899.Q0837New21Game.solution;

public class Solution {
    public double new21Game(int n, int k, int w) {
        double[] dp = new double[k + w];
        double s = 0;
        for (int i = k; i < k + w; i++) {
            dp[i] = i <= n ? 1 : 0;
            s += dp[i];
        }
        for (int i = k - 1; i > -1; i--) {
            dp[i] = s / w;
            s = s - dp[i + w] + dp[i];
        }
        return dp[0];
    }
}