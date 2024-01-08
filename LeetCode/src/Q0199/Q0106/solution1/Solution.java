package Q0199.Q0106.solution1;

import DataStructure.TreeNode;

public class Solution {
    int[] IN;
    int[] POST;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        IN = inorder;
        POST = postorder;
        if (IN.length != POST.length) return null;
        return build(0, inorder.length - 1, postorder.length - 1);
    }


    TreeNode build(int is, int ie, int rii) {
        if (is > ie) return null;
        TreeNode root = new TreeNode(POST[rii]);
        int i = 0;
        while (POST[rii] != IN[ie - i]) i++;

        root.left = build(is, ie - i - 1, rii - i - 1);
        root.right = build(ie - i + 1, ie, rii - 1);
        return root;
    }
}
