package Q0799.Q0778SwiminRisingWater.solution1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    int n;
    int[] p;

    void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    boolean query(int a, int b) {
        return find(a) == find(b);
    }

    int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    public int swimInWater(int[][] grid) {
        n = grid.length;

        // 初始化并查集
        p = new int[n * n];
        for (int i = 0; i < n * n; i++) p[i] = i;

        // 预处理出所有的边
        // edge 存的是 [a, b, w]：代表从 a 到 b 所需要的时间为 w
        // 虽然我们可以往四个方向移动，但是只要对于每个点都添加「向右」和「向下」两条边的话，其实就已经覆盖了所有边了
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = getIndex(i, j);
                p[idx] = idx;
                if (i + 1 < n) {
                    int a = idx, b = getIndex(i + 1, j);
                    int w = Math.max(grid[i][j], grid[i + 1][j]);
                    edges.add(new int[]{a, b, w});
                }
                if (j + 1 < n) {
                    int a = idx, b = getIndex(i, j + 1);
                    int w = Math.max(grid[i][j], grid[i][j + 1]);
                    edges.add(new int[]{a, b, w});
                }
            }
        }

        // 根据权值 w 升序
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        // 从「小边」开始添加，当某一条边别应用之后，恰好使用得「起点」和「结点」联通
        // 那么代表找到了「最短路径」中的「权重最大的边」
        int start = getIndex(0, 0), end = getIndex(n - 1, n - 1);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], w = edge[2];
            union(a, b);
            if (query(start, end)) {
                return w;
            }
        }
        return 0;
    }

    int getIndex(int i, int j) {
        return i * n + j;
    }
}