package Q0799.Q0787CheapestFlightsWithinKStops.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    class Edge {
        int x, y, w;

        Edge(int _x, int _y, int _w) {
            x = _x;
            y = _y;
            w = _w;
        }
    }

    int N = 110, INF = 0x3f3f3f3f;
    int[] dist = new int[N];
    List<Edge> list = new ArrayList<>();
    int n, m, s, t, k;

    public int findCheapestPrice(int _n, int[][] flights, int _src, int _dst, int _k) {
        n = _n;
        s = _src;
        t = _dst;
        k = _k + 1;
        for (int[] f : flights) {
            list.add(new Edge(f[0], f[1], f[2]));
        }
        m = list.size();
        int ans = bf();
        return ans > INF / 2 ? -1 : ans;
    }

    int bf() {
        Arrays.fill(dist, INF);
        dist[s] = 0;
        for (int i = 0; i < k; i++) {
            int[] clone = dist.clone();
            for (Edge e : list) {
                int x = e.x, y = e.y, w = e.w;
                dist[y] = Math.min(dist[y], clone[x] + w);
            }
        }
        return dist[t];
    }
}
