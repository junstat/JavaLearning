package Q0099.Q0078Subsets.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    int[] nums;
    int n;

    public List<List<Integer>> subsets(int[] _nums) {
        nums = _nums;
        n = nums.length;
        dfs(0);
        return ans;
    }

    void dfs(int u) {
        ans.add(new ArrayList<>(cur));
        for (int i = u; i < n; i++) {
            cur.add(nums[i]);
            dfs(i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}