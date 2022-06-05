package Q0499.Q0404SumofLeftLeaves;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode.left != null) {
                if (isLeafNode(curNode.left)) res += curNode.left.val;
                else queue.offer(curNode.left);
            }
            if (curNode.right != null && !isLeafNode(curNode.right))
                queue.offer(curNode.right);
        }
        return res;
    }

    private boolean isLeafNode(TreeNode node) {
        return node.left == null & node.right == null;
    }
}
