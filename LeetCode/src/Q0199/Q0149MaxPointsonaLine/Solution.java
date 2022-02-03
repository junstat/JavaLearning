package Q0199.Q0149MaxPointsonaLine;

import java.util.HashMap;
import java.util.Map;

/*
    思路: 直线点斜式方程，一个点加一个斜率
    斜率 slope = dy / dx，用分数表示斜率，求分子分母的最大公约数，约分，最后将`分子@分母`作为key存储到 HashMap
    细节，平面内如果有重叠的点，按照正常的算法约分，会出现0的情况，所以需要单独用一个变量记录重复点的个数，而重复点
    一定是过当前点的直线的。
 */
public class Solution {
    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 0;
            int max = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(dx, dy);
                dx = dx / gcd;
                dy = dy / gcd;
                String key = dx + "@" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }

            res = Math.max(res, max + duplicate + 1);
        }
        return res;
    }

    // private int gcd(int a, int b) {
    //     return b == 0 ? a : gcd(b, a % b);
    // }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
