package Q0599.Q0513FindBottomLeftTreeValue.solution2;

import DataStructure.TreeNode;

public class Solution {
    int max, ans;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 1);
        return ans;
    }

    void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > max) {
            max = depth;
            ans = root.val;
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}