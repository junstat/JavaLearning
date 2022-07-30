package Q0799.Q0700SearchinaBinarySearchTree.solution1;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val < val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}