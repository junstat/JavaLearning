package Q0099.Q0039CombinationSum.summary;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> result = permute(nums, 3);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> permute(int[] nums, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        permutationAux(nums, n, new ArrayList<>(), ans);
        return ans;
    }

    private void permutationAux(int[] nums, int n, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == n) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int num : nums) {
                if (cur.contains(num)) continue; // element already exists, skip
                cur.add(num);
                permutationAux(nums, n, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
