package Q1699.Q1691MaximumHeightbyStackingCuboids.solution;

import java.util.Arrays;

public class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }

        // 保证枚举关系拓扑性的排序都可以
        Arrays.sort(cuboids, (int[] a, int[] b) -> {
            if (a[2] == b[2]) {
                return (a[0] + a[1]) - (b[0] + b[1]);
            }
            return a[2] - b[2];
        });
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (cuboids[j][0] <= cuboids[i][0] && cuboids[j][1] <= cuboids[i][1] &&
                        cuboids[j][2] <= cuboids[i][2])
                    f[i] = Math.max(f[i], f[j]);
            }
            f[i] += cuboids[i][2];
        }
        return Arrays.stream(f).max().getAsInt();
    }
}
