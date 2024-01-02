package Q0099.Q0090.solution1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    回溯法
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, ArrayList<Integer> curRes, int[] nums, int start) {
        list.add(new ArrayList<>(curRes));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;  // skip duplicates
            curRes.add(nums[i]);
            backtrack(list, curRes, nums, i + 1);
            curRes.remove(curRes.size() - 1);
        }
    }
}
