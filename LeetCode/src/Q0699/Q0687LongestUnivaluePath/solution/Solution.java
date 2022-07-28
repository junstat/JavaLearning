package Q0699.Q0687LongestUnivaluePath.solution;

import DataStructure.TreeNode;

public class Solution {
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return Math.max(0, ans - 1);
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        if (root.left == null || root.left.val != root.val) left = 0;
        if (root.right == null || root.right.val != root.val) right = 0;
        ans = Math.max(ans, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}