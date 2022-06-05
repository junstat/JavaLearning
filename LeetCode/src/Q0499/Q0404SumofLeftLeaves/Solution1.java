package Q0499.Q0404SumofLeftLeaves;

import DataStructure.TreeNode;

public class Solution1 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return isLeft ? root.val : 0;
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }
}
