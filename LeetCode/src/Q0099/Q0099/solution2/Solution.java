package Q0099.Q0099.solution2;

import DataStructure.TreeNode;

public class Solution {
    TreeNode cur = null, first = null, second = null, parent = null, pre = null;

    public void recoverTree(TreeNode root) {
        cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // the left subtree's rightmost node is predecessor
                pre = cur.left;
                while (pre.right != null && pre.right != cur)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    labelNode();
                    pre.right = null;
                    cur = cur.right;
                }
            } else {
                labelNode();
                cur = cur.right;
            }
        }
        // swap two node values
        swap();
    }

    void labelNode() {
        if (parent != null && cur.val < parent.val) {
            second = cur;
            if (first == null)
                first = parent;
        }
        parent = cur;
    }

    void swap() {
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}