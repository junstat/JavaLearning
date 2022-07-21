package Q0099.Q0039CombinationSum.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int[] cs;

    public List<List<Integer>> combinationSum(int[] candidates, int t) {
        cs = candidates;
        Arrays.sort(cs);
        dfs(t, 0);
        return ans;
    }

    /**
     * @param t: 很剩多少值需要凑成。起始值为target，代表还没选择任何数；当t=0，代表选择的数凑成了target
     * @param u: 当前决策到cs[]中的第几位
     */
    void dfs(int t, int u) {
        if (t == 0) {
            ans.add(new ArrayList<>(cur));
        }
        for (int i = u; i < cs.length && t >= cs[i]; i++) {
            cur.add(cs[i]);
            dfs(t - cs[i], i);
            cur.remove(cur.size() - 1);
        }
    }
}