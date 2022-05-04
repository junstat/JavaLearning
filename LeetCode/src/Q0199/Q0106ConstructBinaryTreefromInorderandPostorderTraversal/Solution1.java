package Q0199.Q0106ConstructBinaryTreefromInorderandPostorderTraversal;

import DataStructure.TreeNode;

public class Solution1 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        return buildTree(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private static TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int rootIndex) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[rootIndex]);
        int i = 0;
        while (postorder[rootIndex] != inorder[inEnd - i]) {
            i++;
        }

        root.left = buildTree(inorder, postorder, inStart, inEnd - i - 1, rootIndex - i - 1);
        root.right = buildTree(inorder, postorder, inEnd - i + 1, inEnd, rootIndex - 1);

        return root;
    }
}
