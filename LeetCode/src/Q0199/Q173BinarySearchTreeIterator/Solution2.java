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