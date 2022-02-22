package Q0299.Q0226InvertBinaryTree;

import DataStructure.TreeNode;

/*
    Lets start with straightforward - recursive DFS - it's easy to write and pretty much concise.
 */
public class Solution1 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}