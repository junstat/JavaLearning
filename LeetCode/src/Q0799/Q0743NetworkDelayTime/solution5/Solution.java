package Q0799.Q0743NetworkDelayTime.solution5;

import java.util.Arrays;

public class Solution {
    int N = 110, M = 6010;
    // 邻接表
    int[] he = new int[N], e = new int[M], ne = new int[M], w = new int[M];
    // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
    int[] dist = new int[N];
    int INF = 0x3f3f3f3f;
    int n, m, k, idx;

    void add(int a, int b, int c) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        w[idx] = c;
        idx++;
    }

    public int networkDelayTime(int[][] ts, int _n, int _k) {
        n = _n;
        k = _k;
        m = ts.length;
        // 初始化链表头
        Arrays.fill(he, -1);
        // 存图
        for (int[] t : ts) {
            int u = t[0], v = t[1], c = t[2];
            add(u, v, c);
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
            for (int a = 1; a <= n; a++) {
                for (int i = he[a]; i != -1; i = ne[i]) {
                    int b = e[i];
                    dist[b] = Math.min(dist[b], prev[a] + w[i]);
                }
            }
        }
    }
}