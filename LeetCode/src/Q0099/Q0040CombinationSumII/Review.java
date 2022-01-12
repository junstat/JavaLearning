package Q0099.Q0040CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
  [Medium]
  Given a collection of candidate numbers (candidates) and a target number (target),
  find all unique combinations in candidates where the candidate numbers sum to target.
  Each number in candidates may only be used once in the combination.
  Note: The solution set must not contain duplicate combinations.

  Example 1:
  Input: candidates = [10,1,2,7,6,1,5], target = 8
  Output:
  [
  [1,1,6],
  [1,2,5],
  [1,7],
  [2,6]
  ]

  Example 2:
  Input: candidates = [2,5,2,1,2], target = 5
  Output:
  [
  [1,2,2],
  [5]
  ]
 */
public class Review {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> tempList, int[] nums, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) list.add(tempList);
        else {
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) continue; // skip duplicates
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(nums[i]);
            }
        }
    }

}
