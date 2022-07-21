package Q0199.Q0120Triangle.solution2;

import java.util.List;

public class Solution {
    Integer[][] dp;

    public int minimumTotal(List<List<Integer>> list) {
        int n = list.size();
        dp = new Integer[n][n];
        return dfs(list, 0, 0);
    }

    public int dfs(List<List<Integer>> list, int i, int j) {
        if (i == list.size()) {
            return 0;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        return dp[i][j] = Math.min(dfs(list, i + 1, j), dfs(list, i + 1, j + 1)) + list.get(i).get(j);
    }
}