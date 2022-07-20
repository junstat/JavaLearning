package Q0099.Q0098ValidateBinarySearchTree.solution3;

import DataStructure.TreeNode;

public class Solution {
    TreeNode cur = null, pre = null, parent = null;
    boolean ans = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                check();
            } else {
                pre = cur.left;
                while (pre.right != null && pre.right != cur) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    check();
                }
            }
        }
        return ans;
    }

    void check() {
        if (parent != null && parent.val >= cur.val) ans = false;
        parent = cur;
        cur = cur.right;
    }
}