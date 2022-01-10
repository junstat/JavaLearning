package Q0099.Q0099RecoverBinarySearchTree;

import DataStructure.TreeNode;
import org.junit.Test;

/*
  [Medium]
  You are given the root of a binary search tree (BST),
  where the values of exactly two nodes of the tree were swapped by mistake.
  Recover the tree without changing its structure.

  Example 1:
  Input: root = [1,3,null,null,2]
  Output: [3,1,null,null,2]
  Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
*/
public class Review {
    @Test
    public void test1() {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(Integer.MIN_VALUE);
        TreeNode node5 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        recoverTree(node1);
    }

    public void recoverTree(TreeNode root) {

    }
}
