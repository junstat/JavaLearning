package Q0099.Q0099RecoverBinarySearchTree;

import DataStructure.TreeNode;

/*
  中序遍历过程中找逆序对，如: 6, 3, 4, 5, 2
  出现了两对逆序对 6, 3 与 5, 2
  由此可以找到待交换的两个结点 6, 2
*/
public class Solution1 {

    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = null;

    public void recoverTree(TreeNode root) {
        traverse(root);

        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);

        if (prevElement != null && prevElement.val > root.val) {
            if (firstElement == null) firstElement = prevElement;
            secondElement = root;
        }

        prevElement = root;
        traverse(root.right);
    }
}
