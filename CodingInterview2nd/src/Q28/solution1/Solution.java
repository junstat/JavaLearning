package Q28.solution1;

import DataStructure.TreeNode;

public class Solution {
    boolean isSymmetrical(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
