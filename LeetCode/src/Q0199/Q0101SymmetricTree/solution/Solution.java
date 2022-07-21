package Q0199.Q0101SymmetricTree.solution;

import DataStructure.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricAux(root.left, root.right);
    }

    private boolean isSymmetricAux(TreeNode left, TreeNode right) {
        if (left == null || right == null)
            return left == right;
        if (left.val != right.val)
            return false;
        return isSymmetricAux(left.left, right.right) && isSymmetricAux(left.right, right.left);
    }
}
