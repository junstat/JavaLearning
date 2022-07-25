package Q0699.Q0652FindDuplicateSubtrees.solution;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> map = new HashMap<>();
        List<TreeNode> dups = new ArrayList<>();
        serialize(root, map);
        for (List<TreeNode> group : map.values()) {
            if (group.size() > 1) dups.add(group.get(0));
        }
        return dups;
    }

    String serialize(TreeNode node, Map<String, List<TreeNode>> map) {
        if (node == null) return "";
        String s = "(" + serialize(node.left, map) + node.val + serialize(node.right, map) + ")";
        if (!map.containsKey(s)) map.put(s, new ArrayList<>());
        map.get(s).add(node);
        return s;
    }
}