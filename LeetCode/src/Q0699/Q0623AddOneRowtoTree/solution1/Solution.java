package Q0699.Q0623AddOneRowtoTree.solution1;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = t.left;
                    b.right = t.right;
                    t.left = a;
                    t.right = b;
                } else {
                    if (t.left != null) d.addLast(t.left);
                    if (t.right != null) d.addLast(t.right);
                }
            }
            cur++;
        }
        return root;
    }
}