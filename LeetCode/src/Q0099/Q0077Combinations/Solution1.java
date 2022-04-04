package Q0099.Q0077Combinations;

import java.util.ArrayList;
import java.util.List;

/*
    Solution 1: Backtracking
 */
public class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> curResult, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            curResult.add(i);
            combine(result, curResult, i + 1, n, k - 1);
            curResult.remove(curResult.size() - 1);
        }
    }
}
