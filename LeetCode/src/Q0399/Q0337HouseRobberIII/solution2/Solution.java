package Q0399.Q0337HouseRobberIII.solution2;

import DataStructure.TreeNode;

import java.util.HashMap;

/*
    Step II -- Think one step further
    In step I, we only considered the aspect of "optimal substructure", but think little about the possibilities of
    overlapping of the subproblems. For example, to obtain rob(root), we need rob(root.left), rob(root.right), rob
    (root.left.left), rob(root.left.right), rob(root.right.left), rob(root.right.right); but to get rob(root.left),
    we also need rob(root.left.left), rob(root.left.right), similarly for rob(root.right). The naive solution above
    computed these subproblems repeatedly, which resulted in bad time performance. Now if you recall the two
    conditions for dynamic programming (DP): "optimal substructure" + "overlapping of subproblems", we actually have
    a DP problem. A naive way to implement DP here is to use a hash map to record the results for visited subtrees.
 */
public class Solution {
    public int rob(TreeNode root) {
        return robAux(root, new HashMap<>());
    }

    private int robAux(TreeNode root, HashMap<TreeNode, Integer> map) {
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
