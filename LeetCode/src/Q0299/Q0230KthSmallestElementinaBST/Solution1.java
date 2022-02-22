package Q0299.Q0230KthSmallestElementinaBST;

import DataStructure.TreeNode;

/*
    1) 先计算左子树结点个数lenLeft，若 k <= lenLeft，递归到左子树查找;
    2) 若 k > lenLeft + 1(左子树与当前结点数和)，递归到右子树查找

    time complexity: O(n) best, O(n^2) worst
 */
public class Solution1 {
    public int kthSmallest(TreeNode root, int k) {
        int lenLeft = countNodes(root.left);
        if (k <= lenLeft) {
            return kthSmallest(root.left, k);
        } else if (k > lenLeft + 1) {
            return kthSmallest(root.right, k - 1 - lenLeft);  // 去掉左子树结点数，当前结点
        }
        return root.val;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}