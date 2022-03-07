package Q0099.Q0047PermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    /*
        DFS: Depth First Search, 深度优先搜索，从图中某个顶点v0出发，访问此顶点，然后依次从v0的未被访问的邻接点出发递归地进行同样的深度
        优先搜索，直至图中所有和v0有路径相通的顶点都被访问到。
     */
    private void backtrack(List<List<Integer>> list, ArrayList<Integer> curRes, int[] nums, boolean[] used) {
        if (curRes.size() == nums.length) {
            list.add(new ArrayList<>(curRes));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                curRes.add(nums[i]);
                backtrack(list, curRes, nums, used);
                used[i] = false;
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
