package Q0199.Q173BinarySearchTreeIterator.solution1;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    Deque<TreeNode> d = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
        // 步骤 1
        dfsLeft(root);
    }

    public int next() {
        // 步骤 2
        TreeNode root = d.pollLast();
        int ans = root.val;
        // 步骤 3
        root = root.right;
        // 步骤 1
        dfsLeft(root);
        return ans;
    }

    void dfsLeft(TreeNode root) {
        while (root != null) {
            d.addLast(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !d.isEmpty();
    }
}