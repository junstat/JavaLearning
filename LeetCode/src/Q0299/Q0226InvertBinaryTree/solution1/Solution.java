package Q0299.Q0226InvertBinaryTree.solution1;

import DataStructure.TreeNode;

/*
    Lets start with straightforward - recursive DFS - it's easy to write and pretty much concise.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}