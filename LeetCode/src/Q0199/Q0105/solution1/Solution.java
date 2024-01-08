package Q0199.Q0105.solution1;

import DataStructure.TreeNode;

public class Solution {
    int[] PRE; // 先序序列
    int[] IN;  // 中序序列

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        PRE = preorder;
        IN = inorder;
        return build(0, 0, IN.length - 1);
    }

    TreeNode build(int ps, int is, int ie) {
        // start of preorder 即为 root
        if (ps > PRE.length - 1 || is > ie) return null;
        TreeNode root = new TreeNode(PRE[ps]);
        int rii = 0;  // Index of current root in inorder
        for (int i = is; i <= ie; i++) {
            if (IN[i] == root.val) {
                rii = i;
                break;
            }
        }
        // 左子树: root为 PRE[preStat+1], range: [inStart, inIndex - 1] =>
        // 左子树元素个数 inIndex - 1 - inStart + 1 = inIndex - inStart
        root.left = build(ps + 1, is, rii - 1);
        // 右子树: root为 preStart + inIndex - inStart + 1(先序遍历中，越过 root, 越过 左子树范围 的下一个节点)
        root.right = build(ps + rii - is + 1, rii + 1, ie);
        return root;
    }
}

