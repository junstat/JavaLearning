package Q0099.Q0099RecoverBinarySearchTree;

import DataStructure.TreeNode;


public class Solution1 {

    /*
      Morris Inorder Traversal

      current = root
      while current is not null:
         if not exists current.left:
             visit(current)
             current = current.right
         else:
             predecessor = findPredecessor(current)
             if not exists predecessor.right:
                  predecessor.right = current
                  current = current.left
             else:
                  predecessor.right = null
                  visit(current)
                  current = current.right

    */
    public void morrisTraversal(TreeNode root) {
        TreeNode predecessor = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.println(current.val);
                current = current.right;
            } else {
                // the left subtree's rightmost node is predecessor
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current)
                    predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    predecessor.right = null;
                    System.out.println(current.val);
                    current = current.right;
                }
            }
        }
    }

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null, second = null;
        TreeNode predecessor = null;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                if (pre != null && pre.val > current.val) {
                    if (first == null) first = pre;
                    second = current;
                }
                pre = current;
                current = current.right;
            } else {
                // the left subtree's rightmost node is predecessor
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current)
                    predecessor = predecessor.right;
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    if (pre != null && pre.val > current.val) {
                        if (first == null) first = pre;
                        second = current;
                    }
                    pre = current;
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }

        // swap two node values
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }

}



