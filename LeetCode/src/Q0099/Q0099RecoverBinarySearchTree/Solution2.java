package Q0099.Q0099RecoverBinarySearchTree;

import DataStructure.TreeNode;

public class Solution2 {
    private TreeNode cur = null, first = null, second = null, pre = null;

    public void recoverTree(TreeNode root) {
        TreeNode predecessor = null;
        cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // the left subtree's rightmost node is predecessor
                predecessor = cur.left;
                while (predecessor.right != null && predecessor.right != cur)
                    predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = cur;
                    cur = cur.left;
                } else {
                    labelNode();

                    predecessor.right = null;
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

    private void labelNode() {
        if (pre != null && cur.val < pre.val) {
            second = cur;
            if (first == null)
                first = pre;
        }
        pre = cur;
    }

    private void swap() {
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
