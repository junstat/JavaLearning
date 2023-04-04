package Q1099.Q1000MinimumCosttoMergeStones.solution2;

public class Solution {
    private int dp[][];
    private int s[];
    private int k;

    public int mergeStones(int[] stones, int k) {
        this.k = k;
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0)
            return -1;
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i + 1] = stones[i] + s[i];
        }
        dp = new int[n][n];
        return dfs(0, n - 1);
    }

    public int dfs(int i, int j) {
        if (i == j)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        int res = Integer.MAX_VALUE;
        for (int m = i; m < j; m += k - 1) {
            res = Math.min(res, dfs(i, m) + dfs(m + 1, j));
        }
        if ((j - i) % (k - 1) == 0)
            res += s[j + 1] - s[i];
        return dp[i][j] = res;
    }
}