package Q2499.Q2415;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    void dfs(TreeNode root1, TreeNode root2, boolean isOdd) {
        if (root1 == null) return;
        if (isOdd) {
            int tmp = root1.val;
            root1.val = root2.val;
            root2.val = tmp;
        }
        dfs(root1.left, root2.right, !isOdd);
        dfs(root1.right, root2.left, !isOdd);
    }
}