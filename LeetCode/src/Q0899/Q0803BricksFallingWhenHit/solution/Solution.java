package Q0899.Q0803BricksFallingWhenHit.solution;

import java.util.Arrays;

public class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int[][] grid;
    int rows, cols;

    public int[] hitBricks(int[][] _grid, int[][] hits) {
        grid = _grid;
        rows = grid.length;
        cols = grid[0].length;

        DisjointSet ds = new DisjointSet(rows * cols + 1);

        // Mark cells to hit as 2.
        for (int[] hit : hits) {
            if (grid[hit[0]][hit[1]] == 1) grid[hit[0]][hit[1]] = 2;
        }

        // Union around 1 cells.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) unionAround(i, j, ds);
            }
        }

        int numBricksLeft = ds.size[ds.find(0)]; // numBricksLeft after the last erasure.
        int i = hits.length - 1; // Index of erasure.
        int[] numBricksDropped = new int[hits.length];  // Number of bricks that will drop after each erasure.

        while (i >= 0) {
            int x = hits[i][0];
            int y = hits[i][1];

            if (grid[x][y] == 2) {
                grid[x][y] = 1; // Restore to last erasure.
                unionAround(x, y, ds);
                int newNumBricksLeft = ds.size[ds.find(0)];
                numBricksDropped[i] = Math.max(newNumBricksLeft - numBricksLeft - 1, 0);
                numBricksLeft = newNumBricksLeft;
            }
            i--;
        }
        return numBricksDropped;
    }

    void unionAround(int x, int y, DisjointSet ds) {
        int curMark = mark(x, y);

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && grid[nx][ny] == 1) {
                ds.union(curMark, mark(nx, ny));
            }
        }

        if (x == 0) ds.union(0, curMark); // connect to the top of the grid.
    }

    int mark(int x, int y) {
        return x * cols + y + 1;
    }

    static class DisjointSet {
        int[] parent, size;

        public DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {  // 0 indicates top of the grid.
                parent[i] = i;
            }
        }

        int find(int x) {
            if (x == parent[x]) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}
