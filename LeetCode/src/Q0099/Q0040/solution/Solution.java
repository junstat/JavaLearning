package Q0099.Q0040.solution;

import java.util.*;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int[] cs;

    public List<List<Integer>> combinationSum2(int[] candidates, int t) {
        cs = candidates;
        Arrays.sort(cs);
        dfs(t, 0);
        return ans;
    }

    void dfs(int t, int start) {
        if (t == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < cs.length && t >= cs[i]; i++) {
            if (i != start && cs[i] == cs[i - 1]) continue;
            cur.add(cs[i]);
            dfs(t - cs[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}