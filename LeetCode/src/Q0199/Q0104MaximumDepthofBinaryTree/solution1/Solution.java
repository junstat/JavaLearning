package Q0199.Q0104MaximumDepthofBinaryTree.solution1;

import DataStructure.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
