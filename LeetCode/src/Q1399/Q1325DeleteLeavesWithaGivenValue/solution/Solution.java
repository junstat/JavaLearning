package Q1399.Q1325DeleteLeavesWithaGivenValue.solution;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int t) {
        if (root == null) return null;
        root.left = removeLeafNodes(root.left, t);
        root.right = removeLeafNodes(root.right, t);
        if (root.left == null && root.right == null && root.val == t) {
            return null;
        }
        return root;
    }
}
