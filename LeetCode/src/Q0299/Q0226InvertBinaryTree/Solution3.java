package Q0299.Q0226InvertBinaryTree;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
    Finally we can easily convert the above solution to BFS - or so called level order traversal.
 */
public class Solution3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }
}