package Q36.solution;

import DataStructure.TreeNode;

public class Solution {
    TreeNode lastNodeInList = null;

    public TreeNode Convert(TreeNode root) {
        convertNode(root);
        TreeNode head = lastNodeInList;
        while (head != null && head.left != null) head = head.left;
        return head;
    }

    void convertNode(TreeNode root) {
        if (root == null) return;
        if (root.left != null) convertNode(root.left);
        root.left = lastNodeInList;
        if (lastNodeInList != null)
            lastNodeInList.right = root;
        lastNodeInList = root;
        if (root.right != null)
            convertNode(root.right);
    }
}