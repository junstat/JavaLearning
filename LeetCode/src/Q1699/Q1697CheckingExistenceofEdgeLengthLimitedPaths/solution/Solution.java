package Q1699.Q1697CheckingExistenceofEdgeLengthLimitedPaths.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    int[] fa;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {

        Integer[] id = IntStream.range(0, queries.length).boxed().toArray(Integer[]::new);
        Arrays.sort(id, Comparator.comparingInt(a -> queries[a][2]));

        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;

        boolean[] ans = new boolean[queries.length];

        int j = 0;
        for (int i : id) {
            int[] q = queries[i];
            while (j < edgeList.length && edgeList[j][2] < q[2]) {
                merge(edgeList[j][0], edgeList[j][1]);
                j++;
            }
            if (find(q[0]) == find(q[1])) {
                ans[i] = true;
            }

        }
        return ans;
    }

    int find(int x) {
        if (x != fa[x]) return fa[x] = find(fa[x]);
        return fa[x];
    }

    void merge(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            fa[py] = px;
        }
    }
}