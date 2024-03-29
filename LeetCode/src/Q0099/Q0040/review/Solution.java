package Q0099.Q0040.review;

import org.junit.Test;

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
public class Solution {
    @Test
    public void test1() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        return null;
    }
}
