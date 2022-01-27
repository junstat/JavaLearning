package Q0199.Q173BinarySearchTreeIterator;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution2 {
}

/*
   方法二: 改递归为栈
  */
class BSTIterator {
    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new ArrayDeque<>();
        this.leftMostInorder(root);
    }

    private void leftMostInorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topMostNode = this.stack.pop();

        if (topMostNode.right != null) {
            this.leftMostInorder(topMostNode.right);
        }

        return topMostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}