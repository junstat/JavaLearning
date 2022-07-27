package Q54.solution;

import DataStructure.TreeNode;

public class Solution {
    int k, ans = -1;

    public int KthNode(TreeNode root, int _k) {
        k = _k;
        if (root == null || k <= 0) return -1;
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null || k <= 0) return;
        dfs(root.left);
        if (--k == 0) ans = root.val;
        dfs(root.right);
    }
}