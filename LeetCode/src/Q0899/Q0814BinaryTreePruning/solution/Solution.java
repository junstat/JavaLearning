package Q0899.Q0814BinaryTreePruning.solution;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left != null || root.right != null) return root;
        return root.val == 0 ? null : root;
    }
}
