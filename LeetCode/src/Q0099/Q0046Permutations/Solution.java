package Q0099.Q0046Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutationAux(nums, new ArrayList<>(), ans);
        return ans;
    }

    private void permutationAux(int[] nums, List<Integer> cur, List<List<Integer>> ans) {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int num : nums) {
                if (cur.contains(num)) continue; // element already exists, skip
                cur.add(num);
                permutationAux(nums, cur, ans);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
