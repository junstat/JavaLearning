package Q0799.Q0743NetworkDelayTime.solution4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class Edge {
        int a, b, c;

        Edge(int _a, int _b, int _c) {
            a = _a;
            b = _b;
            c = _c;
        }
    }

    int N = 110, M = 6010;
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    int INF = 0x3f3f3f3f;
    int n, m, k;
    // 使用类进行存边
    List<Edge> es = new ArrayList<>();

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        m = ts.length;
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            es.add(new Edge(u, v, c));
        }
        // 最短路
        bf();
        // 遍历答案
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans > INF / 2 ? -1 : ans;
    }

    void bf() {
        // 起始先将所有的点标记为「距离为正无穷」
        Arrays.fill(dist, INF);
        // 只有起点最短距离为 0
        dist[k] = 0;
        // 迭代 n 次
        for (int p = 1; p <= n; p++) {
            int[] prev = dist.clone();
            // 每次都使用上一次迭代的结果，执行松弛操作
            for (Edge e : es) {
                int a = e.a, b = e.b, c = e.c;
                dist[b] = Math.min(dist[b], prev[a] + c);
            }
        }
    }
}