package Q0599.Q0576OutofBoundaryPaths.solution2;

public class Solution {
    int MOD = (int) 1e9 + 7;
    int m, n, max;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int findPaths(int _m, int _n, int _max, int r, int c) {
        m = _m;
        n = _n;
        max = _max;
        int[][] f = new int[m * n][max + 1];
        // 初始化边缘格子的路径数量
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) add(i, j, f);
                if (j == 0) add(i, j, f);
                if (i == m - 1) add(i, j, f);
                if (j == n - 1) add(i, j, f);
            }
        }
        // 从小到大枚举「可移动步数」
        for (int k = 1; k <= max; k++) {
            // 枚举所有的「位置」
            for (int idx = 0; idx < m * n; idx++) {
                int[] info = parseIdx(idx);
                int x = info[0], y = info[1];
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    int nidx = getIdx(nx, ny);
                    f[idx][k] += f[nidx][k - 1];
                    f[idx][k] %= MOD;
                }
            }
        }
        return f[getIdx(r, c)][max];
    }

    void add(int x, int y, int[][] f) {
        for (int k = 1; k <= max; k++) {
            f[getIdx(x, y)][k]++;
        }
    }

    int getIdx(int x, int y) {
        return x * n + y;
    }

    int[] parseIdx(int idx) {
        return new int[]{idx / n, idx % n};
    }
}