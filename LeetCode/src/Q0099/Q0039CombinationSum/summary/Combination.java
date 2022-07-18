package Q0099.Q0039CombinationSum.summary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = combine(nums, 3);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combine(int[] nums, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationAux(nums, 0, n, new ArrayList<>(), ans);
        return ans;
    }

    public void combinationAux(int[] nums, int start, int n, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == n) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                combinationAux(nums, i + 1, n, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
