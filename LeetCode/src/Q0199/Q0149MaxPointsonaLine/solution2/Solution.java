package Q0199.Q0149MaxPointsonaLine.solution2;

import java.util.HashMap;
import java.util.Map;

/*
    思路: 直线点斜式方程，一个点加一个斜率
    斜率 slope = dy / dx，用分数表示斜率，求分子分母的最大公约数，约分，最后将`分子@分母`作为key存储到 HashMap
    细节，平面内如果有重叠的点，按照正常的算法约分，会出现0的情况，所以需要单独用一个变量记录重复点的个数，而重复点
    一定是过当前点的直线的。
 */
public class Solution {
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            // 由当前点 i 发出的直线所经过的最多点数量
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int x1 = ps[i][0], y1 = ps[i][1], x2 = ps[j][0], y2 = ps[j][1];
                int a = x1 - x2, b = y1 - y2;
                int k = gcd(a, b);
                String key = (a / k) + "_" + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            ans = Math.max(ans, max + 1);
        }
        return ans;
    }

    int gcd(int a, int b) {
        // return b == 0 ? a : gcd(b, a % b);
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}