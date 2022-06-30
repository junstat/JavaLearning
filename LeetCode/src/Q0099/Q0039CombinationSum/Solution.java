package Q0099.Q0039CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] cs, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(cs, t, 0, ans, cur);
        return ans;
    }

    /**
     * cs: 原数组，从该数组进行选数
     * t: 还剩多少值需要凑成。起始值为 target ，代表还没选择任何数；当 t = 0，代表选择的数凑成了 target
     * u: 当前决策到 cs[] 中的第几位
     * ans: 最终结果集
     * cur: 当前结果集
     */
    void dfs(int[] cs, int t, int u, List<List<Integer>> ans, List<Integer> cur) {
        if (t == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        if (u == cs.length || t < 0) return;

        // 枚举 cs[u] 的使用次数w
        for (int i = 0; cs[u] * i <= t; i++) {
            dfs(cs, t - cs[u] * i, u + 1, ans, cur);
            cur.add(cs[u]);
        }
        // 进行回溯。注意回溯总是将数组的最后一位弹出
        for (int i = 0; cs[u] * i <= t; i++) {
            cur.remove(cur.size() - 1);
        }
    }
}