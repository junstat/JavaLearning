package Q0299.Q0222CountCompleteTreeNodes;

import DataStructure.TreeNode;

public class Solution3 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        TreeNode l = root, r = root;
        int h = 0;
        while (r != null) {
            l = l.left;
            r = r.right;
            h++;
        }
        if (l == null) return (1 << h) - 1; // 满二叉树
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
