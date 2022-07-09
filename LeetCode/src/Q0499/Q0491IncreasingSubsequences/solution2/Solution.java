package Q0499.Q0491IncreasingSubsequences.solution2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums, 0, Integer.MIN_VALUE);
        return ans;
    }

    void backtrack(int[] nums, int index, int flag) {
        if (index == nums.length) {
            if (res.size() > 1) {
                ans.add(new ArrayList(res));
            }
            return;
        }
        if (nums[index] >= flag) {
            res.add(nums[index]);
            backtrack(nums, index + 1, nums[index]);
            res.remove(res.size() - 1);
        }
        if (nums[index] != flag) {
            backtrack(nums, index + 1, flag);
        }
    }
}

