package Q0499.Q0491IncreasingSubsequences.solution1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<List<Integer>> set = new HashSet<>();
    List<Integer> cur = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] _nums) {
        nums = _nums;
        dfs(0);
        return new ArrayList<>(set);
    }

    void dfs(int index) {
        if (cur.size() > 1) set.add(new ArrayList<>(cur));
        for (int i = index; i < nums.length; i++) {
            if (cur.size() == 0 || cur.get(cur.size() - 1) <= nums[i]) {
                cur.add(nums[i]);
                dfs(i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}