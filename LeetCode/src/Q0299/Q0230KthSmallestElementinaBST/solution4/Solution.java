package Q0299.Q0230KthSmallestElementinaBST.solution4;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    二叉搜索树的中序遍历是有序序列，在遍历过程中计数。
    迭代实现
    time complexity: O(n)
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode node = stack.pop();
            k--;
            if (k == 0) return node.val;
            TreeNode right = node.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return -1;
    }
}