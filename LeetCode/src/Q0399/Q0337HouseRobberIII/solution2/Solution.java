package Q0399.Q0337HouseRobberIII.solution2;

import DataStructure.TreeNode;

import java.util.HashMap;

public class Solution {
    public int rob(TreeNode root) {
        return robAux(root, new HashMap<>());
    }

    int robAux(TreeNode root, HashMap<TreeNode, Integer> map) {
        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int result = 0;
        if (root.left != null)
            result += robAux(root.left.left, map) + robAux(root.left.right, map);

        if (root.right != null)
            result += robAux(root.right.left, map) + robAux(root.right.right, map);

        result = Math.max(result + root.val, robAux(root.left, map) + robAux(root.right, map));
        map.put(root, result);

        return result;
    }
}
