package Q0699.Q0695MaxAreaofIsland.solution3;

import java.util.Arrays;

public class Solution {
    static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int n;

    static class UnionFind {
        int[] id, size;

        UnionFind(int n) {
            id = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) id[i] = i;
        }

        int find(int x) {
            return id[x] == x ? x : (id[x] = find(id[x]));
        }

        void connect(int x, int y) {
            int p = find(x), q = find(y);
            if (p == q) return;
            id[p] = q;
            size[q] += size[p];
        }

        int getSize(int x) {
            return size[x];
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, ans = 0;
        n = grid[0].length;
        UnionFind uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                for (int[] dir : dirs) {
                    int dx = dir[0], dy = dir[1];
                    int a = i + dx, b = j + dy;
                    if (a < 0 || a >= m || b < 0 || b >= n || grid[a][b] == 0) continue;
                    uf.connect(getKey(i, j), getKey(a, b));
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) ans = Math.max(ans, uf.getSize(getKey(i, j)));
            }
        }
        return ans;
    }

    int getKey(int i, int j) {
        return i * n + j;
    }
}
