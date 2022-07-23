package Q0599.Q0563BinaryTreeTilt.solution;

import DataStructure.TreeNode;

public class Solution {
    int ans;

    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        ans += Math.abs(l - r);
        return l + r + root.val;
    }
}
