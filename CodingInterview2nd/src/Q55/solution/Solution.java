package Q55.solution;

import DataStructure.TreeNode;

public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        return 1 + Math.max(l, r);
    }
}