package Q0199.Q0111.solution;

import DataStructure.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int lh = minDepth(root.left), rh = minDepth(root.right);
        return (lh == 0 || rh == 0) ? lh + rh + 1 : Math.min(lh, rh) + 1;
    }
}
