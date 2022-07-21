package Q0499.Q0437PathSumIII.solution2;

import DataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int ans, t;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        t = sum;
        map.put(0, 1);
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode root, int val) {
        if (map.containsKey(val - t)) ans += map.get(val - t);
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (root.left != null) dfs(root.left, val + root.left.val);
        if (root.right != null) dfs(root.right, val + root.right.val);
        map.put(val, map.getOrDefault(val, 0) - 1);
    }
}