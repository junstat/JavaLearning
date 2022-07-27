package Q68.solution;

import DataStructure.TreeNode;

public class Solution {
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root.val > p && root.val > q)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p && root.val < q)
            return lowestCommonAncestor(root.right, p, q);
        return root.val;
    }
}
