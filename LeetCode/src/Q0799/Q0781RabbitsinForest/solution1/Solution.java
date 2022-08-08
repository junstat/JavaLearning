package Q0799.Q0781RabbitsinForest.solution1;

import java.util.Arrays;

public class Solution {
    public int numRabbits(int[] cs) {
        Arrays.sort(cs);
        int n = cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = cs[i];
            ans += cnt + 1;
            // 跳过「数值 cnt」后面的 cnt 个「数值 cnt」
            int k = cnt;
            while (k-- > 0 && i + 1 < n && cs[i] == cs[i + 1]) i++;
        }
        return ans;
    }
}