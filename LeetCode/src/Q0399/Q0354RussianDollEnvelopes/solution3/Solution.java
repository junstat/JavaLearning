package Q0399.Q0354RussianDollEnvelopes.solution3;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] es) {
        int n = es.length;
        if (n == 0) return n;
        // 由于我们使用了 g 记录高度，因此这里只需将 w 从小到达排序即可
        Arrays.sort(es, (a, b) -> a[0] - b[0]);
        // f(i) 为考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int[] f = new int[n];
        // g(i) 记录的是长度为 i 的最长上升子序列的最小「信封高度」
        int[] g = new int[n];
        // 因为要取 min，用一个足够大（不可能）的高度初始化
        Arrays.fill(g, Integer.MAX_VALUE);
        g[0] = 0;
        int ans = 1;
        for (int i = 0, j = 0, len = 1; i < n; i++) {
            // 对于 w 相同的数据，不更新 g 数组
            if (es[i][0] != es[j][0]) {
                // 限制 j 不能越过 i，确保 g 数组中只会出现第 i 个信封前的「历史信封」
                while (j < i) {
                    int prev = f[j], cur = es[j][1];
                    if (prev == len) {
                        // 与当前长度一致了，说明上升序列多增加一位
                        g[len++] = cur;
                    } else {
                        // 始终保留最小的「信封高度」，这样可以确保有更多的信封可以与其行程上升序列
                        // 举例：同样是上升长度为 5 的序列，保留最小高度为 5 记录（而不是保留任意的，比如 10），这样之后高度为 7 8 9 的信封都能形成序列；
                        g[prev] = Math.min(g[prev], cur);
                    }
                    j++;
                }
            }

            // 二分过程
            // g[i] 代表的是上升子序列长度为 i 的「最小信封高度」
            int l = 0, r = len;
            while (l < r) {
                int mid = l + r >> 1;
                // 令 check 条件为 es[i][1] <= g[mid]（代表 w 和 h 都严格小于当前信封）
                // 这样我们找到的就是满足条件，最靠近数组中心点的数据（也就是满足 check 条件的最大下标）
                // 对应回 g[] 数组的含义，其实就是找到 w 和 h 都满足条件的最大上升长度
                if (es[i][1] <= g[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            // 更新 f[i] 与答案
            f[i] = r;
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
