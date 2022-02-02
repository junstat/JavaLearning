package Q0099.Q0077Combinations;

import java.util.ArrayList;
import java.util.List;

/*
    Solution 1: Backtracking
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void combine(List<List<Integer>> result, List<Integer> tmpResult, int start, int n, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(tmpResult));
            return;
        }
        for (int i = start; i <= n - k + 1; i++) {
            tmpResult.add(i);
            combine(result, tmpResult, i + 1, n, k - 1);
            tmpResult.remove(tmpResult.size() - 1);
        }
    }
}
