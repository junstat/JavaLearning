package Q0099.Q0046.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static int[] nums;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> permute(int[] _nums) {
        nums = _nums;
        permutationAux();
        return ans;
    }

    private void permutationAux() {
        if (cur.size() == nums.length) {
            ans.add(new ArrayList<>(cur));
        } else {
            for (int num : nums) {
                if (cur.contains(num)) continue; // element already exists, skip
                cur.add(num);
                permutationAux();
                cur.remove(cur.size() - 1);
            }
        }
    }
}
