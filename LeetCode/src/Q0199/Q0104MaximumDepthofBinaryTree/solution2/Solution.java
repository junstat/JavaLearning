package Q0199.Q0104MaximumDepthofBinaryTree.solution2;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ++res;
            for (int i = 0, n = queue.size(); i < n; i++) {
                TreeNode p = queue.peek();
                queue.poll();

                if (p.left != null) queue.add(p.left);
                if (p.right != null) queue.add(p.right);
            }
        }
        return res;
    }
}
