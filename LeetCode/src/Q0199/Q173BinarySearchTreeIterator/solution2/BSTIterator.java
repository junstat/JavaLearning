package Q0199.Q173BinarySearchTreeIterator.solution2;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTIterator {
    private final Deque<TreeNode> stack;
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        cur = root;
    }


    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int res = cur.val;
        cur = cur.right;
        return res;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}