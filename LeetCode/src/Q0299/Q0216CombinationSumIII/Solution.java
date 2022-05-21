package Q0299.Q0216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/*
   backtracking 回溯
 */
public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> curResult, int k, int start, int n) {
        if (curResult.size() == k && n == 0) {
            ans.add(new ArrayList<>(curResult));
            return;
        }
        for (int i = start; i <= 9; i++) {
            curResult.add(i);
            combination(ans, curResult, k, i + 1, n - i);
            curResult.remove(curResult.size() - 1);
        }
    }
}
