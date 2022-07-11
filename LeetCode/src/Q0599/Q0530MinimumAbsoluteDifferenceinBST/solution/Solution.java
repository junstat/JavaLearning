package Q0599.Q0530MinimumAbsoluteDifferenceinBST.solution;

import DataStructure.TreeNode;

public class Solution {
    int prev = -1, ans = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != -1) ans = Math.min(ans, root.val - prev);
        prev = root.val;
        dfs(root.right);
    }
}
