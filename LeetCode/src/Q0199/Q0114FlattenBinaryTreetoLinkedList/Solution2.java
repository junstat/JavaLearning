package Q0199.Q0114FlattenBinaryTreetoLinkedList;

import DataStructure.TreeNode;

/*
    iteration
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                // Find current node's previous node that links to current node's right subtree
                TreeNode pre = cur.left;
                while (pre.right != null) pre = pre.right;
                pre.right = cur.right;

                // Use current node's left subtree to replace its right subtree(original right
                // subtree is already linked by current node's previous node
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
