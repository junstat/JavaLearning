package Q13.solution;

public class Solution {
    int k, m, n;
    boolean[][] visited;

    public int movingCount(int _k, int _m, int _n) {
        k = _k;
        m = _m;
        n = _n;
        visited = new boolean[m][n];
        return dfs(0, 0);
    }

    int dfs(int i, int j) {
        int ans = 0;
        int cur = sum(i) + sum(j);
        if (cur <= k && i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
            visited[i][j] = true;
            ans = 1 + dfs(i, j - 1) + dfs(i, j + 1) + dfs(i - 1, j) + dfs(i + 1, j);
        }
        return ans;
    }

    int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n % 10;
            n /= 10;
        }
        return ans;
    }
}