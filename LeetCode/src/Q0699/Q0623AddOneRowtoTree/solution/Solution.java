package Q0699.Q0623AddOneRowtoTree.solution;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        return addOneRow(root, val, depth, true);
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth, boolean left) {
        if (depth <= 0) return root;
        if (depth == 1) {
            TreeNode r = new TreeNode(val);
            if (left) r.left = root;
            else r.right = root;
            return r;
        }
        if (root != null) {
            root.left = addOneRow(root.left, val, depth - 1, true);
            root.right = addOneRow(root.right, val, depth - 1, false);
        }
        return root;
    }
}