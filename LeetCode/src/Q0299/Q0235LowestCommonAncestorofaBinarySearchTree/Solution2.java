package Q0299.Q0235LowestCommonAncestorofaBinarySearchTree;

import DataStructure.TreeNode;

/*
    Solution2: 迭代实现
 */
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        for (; ; ) {
            if (p.val < cur.val && q.val < cur.val)
                cur = cur.left;
            else if (p.val > cur.val && q.val > cur.val)
                cur = cur.right;
            else
                break;
        }
        return cur;
    }
}
