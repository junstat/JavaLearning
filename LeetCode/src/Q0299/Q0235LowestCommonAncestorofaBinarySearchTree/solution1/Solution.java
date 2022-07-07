package Q0299.Q0235LowestCommonAncestorofaBinarySearchTree.solution1;

import DataStructure.TreeNode;

/*
    Solution 1:
        二叉排序树的特性，中序遍历是有序序列，即左 < 根 < 右。
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}
