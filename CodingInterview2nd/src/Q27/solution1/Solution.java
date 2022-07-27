package Q27.solution1;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode Mirror(TreeNode root) {
        if (root == null) return null;

        TreeNode left = root.left, right = root.right;
        root.left = Mirror(right);
        root.right = Mirror(left);
        return root;
    }
}