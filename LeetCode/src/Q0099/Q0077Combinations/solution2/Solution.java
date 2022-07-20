package Q0099.Q0077Combinations.solution2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
    Solution 2: A short recursive solution based on C(n, k) = C(n-1, k-1) + C(n-1, k)
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k == n || k == 0) {
            List<Integer> row = new LinkedList<>();
            for (int i = 1; i <= k; i++) row.add(i);
            return new LinkedList<>(Collections.singletonList(row));
        }
        List<List<Integer>> result = combine(n - 1, k - 1);
        result.forEach(e -> e.add(n));
        result.addAll(combine(n - 1, k));
        return result;
    }
}
