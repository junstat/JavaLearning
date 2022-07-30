package Q0799.Q0700SearchinaBinarySearchTree.solution2;

import DataStructure.TreeNode;

public class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val < val ? root.right : root.left;
        }
        return root;
    }
}