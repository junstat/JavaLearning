package Q0299.Q0216CombinationSumIII.solution;

import java.util.ArrayList;
import java.util.List;

/*
   backtracking 回溯
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combination(k, 1, n);
        return ans;
    }

    private void combination(int k, int start, int n) {
        if (cur.size() == k && n == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            combination(k, i + 1, n - i);
            cur.remove(cur.size() - 1);
        }
    }
}
