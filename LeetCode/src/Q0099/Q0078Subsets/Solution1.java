package Q0099.Q0078Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    void dfs(List<List<Integer>> result, List<Integer> cur, int[] nums, int start) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(result, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}