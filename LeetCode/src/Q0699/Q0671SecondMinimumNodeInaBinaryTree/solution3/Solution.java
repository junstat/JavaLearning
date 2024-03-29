package Q0699.Q0671SecondMinimumNodeInaBinaryTree.solution3;

import DataStructure.TreeNode;

public class Solution {
    int ans = -1;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }

    void dfs(TreeNode root, int cur) {
        if (root == null) return;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}