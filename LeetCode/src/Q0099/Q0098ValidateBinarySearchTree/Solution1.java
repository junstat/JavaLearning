package Q0099.Q0098ValidateBinarySearchTree;

import DataStructure.TreeNode;

/*
    in order traversal, recursion
 */
public class Solution1 {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return validate(root);
    }

    private boolean validate(TreeNode node) {
        if (node == null) return true;
        if (!validate(node.left)) return false;
        if (prev != null && prev.val >= node.val) return false;
        prev = node;
        return validate(node.right);
    }
}