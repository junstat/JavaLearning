package Q0199.Q0110BalancedBinaryTree.solution;

import DataStructure.TreeNode;

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int lh = depth(root.left), rh = depth(root.right);
        return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        return root == null ? 0 : Math.max(depth(root.left), depth(root.right)) + 1;
    }
}