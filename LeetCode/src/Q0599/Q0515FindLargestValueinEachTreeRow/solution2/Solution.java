package Q0599.Q0515FindLargestValueinEachTreeRow.solution2;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Integer> map = new HashMap<>();

    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 1);
        return new ArrayList<>(map.values());
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) return;
        map.put(depth, Math.max(map.getOrDefault(depth, Integer.MIN_VALUE), node.val));
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}