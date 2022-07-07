package Q0299.Q0230KthSmallestElementinaBST.solution3;

import DataStructure.TreeNode;

/*
    二叉搜索树的中序遍历是有序序列，在遍历过程中计数。
    递归实现
    time complexity: O(n)
 */
public class Solution {
    private int result = 0;
    private int cnt = 0;

    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inOrderTraversal(root);
        return result;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root.left != null) inOrderTraversal(root.left);
        cnt--;
        if (cnt == 0) {
            result = root.val;
            return;
        }
        if (root.right != null) inOrderTraversal(root.right);
    }
}