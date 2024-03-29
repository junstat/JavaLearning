package Q0199.Q0112.solution;

import DataStructure.TreeNode;

public class Solution {
    public boolean hasPathSum(TreeNode root, int t) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == t) return true;
        return hasPathSum(root.left, t - root.val) ||
                hasPathSum(root.right, t - root.val);
    }
}
