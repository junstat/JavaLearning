package Q0099.Q0078Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Recursive (Backtracking)
public class Solution1 {
    /*
        Time: O(n * 2^n)
        Space: O(n/2 * 2^n) ~= O(n * 2^n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void subsets(List<List<Integer>> result, ArrayList<Integer> curResult, int[] nums, int start) {
        result.add(new ArrayList<>(curResult));
        for (int i = start; i < nums.length; i++) {
            curResult.add(nums[i]);
            subsets(result, curResult, nums, i + 1);
            curResult.remove(curResult.size() - 1);
        }
    }
}