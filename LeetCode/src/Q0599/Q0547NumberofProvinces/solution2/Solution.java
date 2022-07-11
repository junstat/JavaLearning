package Q0599.Q0547NumberofProvinces.solution2;

// DFS
public class Solution {
    int[][] M;
    boolean[] visited;

    public int findCircleNum(int[][] _M) {
        M = _M;
        visited = new boolean[M.length];
        int cnt = 0;
        for (int i = 0; i < M.length; ++i) {
            if (!visited[i]) {
                dfs(i);
                ++cnt;
            }
        }
        return cnt;
    }

    void dfs(int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 0 || visited[j]) continue;
            visited[j] = true;
            dfs(j);
        }
    }
}
