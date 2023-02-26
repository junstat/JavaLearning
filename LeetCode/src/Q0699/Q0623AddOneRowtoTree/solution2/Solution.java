package Q0699.Q0623AddOneRowtoTree.solution2;

import DataStructure.TreeNode;

public class Solution {
    int d, v;

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        d = depth;
        v = val;
        if (d == 1) return new TreeNode(val, root, null);
        dfs(root, 1);
        return root;
    }

    void dfs(TreeNode root, int cur) {
        if (root == null) return;
        if (cur == d - 1) {
            TreeNode a = new TreeNode(v), b = new TreeNode(v);
            a.left = root.left;
            b.right = root.right;
            root.left = a;
            root.right = b;
        } else {
            dfs(root.left, cur + 1);
            dfs(root.right, cur + 1);
        }
    }
}