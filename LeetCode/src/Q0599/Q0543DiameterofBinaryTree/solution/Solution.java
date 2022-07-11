package Q0599.Q0543DiameterofBinaryTree.solution;

import DataStructure.TreeNode;

public class Solution {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        postOrder(root);
        return ans;
    }

    int postOrder(TreeNode root) {
        if (root == null) return 0;
        int l = postOrder(root.left), r = postOrder(root.right);
        ans = Math.max(ans, l + r);
        return 1 + Math.max(l, r);
    }
}