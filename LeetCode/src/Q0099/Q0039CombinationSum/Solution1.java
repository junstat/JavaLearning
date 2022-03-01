package Q0099.Q0039CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    A general approach to backtracking questions
    Q078 Subsets
    Q090 Subsets II
    Q046 Permutations
    Q047 Permutations II
    Q040 Combination Sum II
    Q131 Palindrome Partitioning
   https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
 */
public class Solution1 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> cur, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(new ArrayList<>(cur));
        else {
            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                backtrack(list, cur, nums, remain - nums[i], i); //  not i + 1 because we can reuse same elements
                cur.remove(cur.size() - 1);
            }
        }
    }
}
