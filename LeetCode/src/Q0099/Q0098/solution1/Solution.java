package Q0099.Q0098.solution1;

import DataStructure.TreeNode;

public class Solution {
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