package Q0099.Q0077Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> cur, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            cur.add(i);
            dfs(result, cur, i + 1, n, k - 1);
            cur.remove(cur.size() - 1);
        }
    }
}