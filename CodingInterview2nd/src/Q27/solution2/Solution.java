package Q27.solution2;

import DataStructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public TreeNode Mirror(TreeNode root) {
        if (root == null) return null;

        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) q.addLast(node.left);
            if (node.right != null) q.addLast(node.right);
        }
        return root;
    }
}