package Q0399.Q0312BurstBalloons.solution1;

public class Solution {
    static int[] balloons;
    static int[][] memo;

    public int maxCoins(int[] nums) {
        balloons = new int[nums.length + 2];
        int n = 1;
        for (int x : nums) if (x > 0) balloons[n++] = x;
        balloons[0] = balloons[n++] = 1;

        memo = new int[n][n];
        return solve(0, n - 1);
    }

    int solve(int i, int j) {
        if (i >= j - 1) return 0;
        if (memo[i][j] > 0) return memo[i][j];
        int ans = 0;
        for (int mid = i + 1; mid < j; mid++)
            ans = Math.max(ans, balloons[i] * balloons[mid] * balloons[j] + solve(i, mid) + solve(mid, j));

        memo[i][j] = ans;
        return ans;
    }
}