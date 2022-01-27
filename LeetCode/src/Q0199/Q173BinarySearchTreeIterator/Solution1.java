package Q0199.Q173BinarySearchTreeIterator;

import DataStructure.TreeNode;

import java.util.ArrayList;

public class Solution1 {
}


/*
   方法一: 使用递归用中序遍历，把所有结点放到ArrayList
  */
class BSTIterator1 {
    private final ArrayList<Integer> nodeSorted;
    int index;

    public BSTIterator1(TreeNode root) {
        this.nodeSorted = new ArrayList<>();
        this.index = -1;
        this.inOrder(root);
    }

    private void inOrder(TreeNode root) {
        if (root == null) return;
        this.inOrder(root.left);
        this.nodeSorted.add(root.val);
        this.inOrder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodeSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodeSorted.size();
    }
}