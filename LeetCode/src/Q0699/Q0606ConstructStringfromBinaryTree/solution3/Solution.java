package Q0699.Q0606ConstructStringfromBinaryTree.solution3;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Deque<Object[]> d = new ArrayDeque<>();
        d.addLast(new Object[]{0, root});
        while (!d.isEmpty()) {
            Object[] poll = d.pollLast();
            int loc = (Integer) poll[0];
            TreeNode t = (TreeNode) poll[1];
            if (loc == 0) {
                sb.append("(");
                sb.append(t.val);
                d.addLast(new Object[]{1, t});
            } else if (loc == 1) {
                d.addLast(new Object[]{2, t});
                if (t.right != null) d.addLast(new Object[]{0, t.right});
                if (t.left != null) d.addLast(new Object[]{0, t.left});
                else if (t.right != null) sb.append("()");
            } else if (loc == 2) {
                sb.append(")");
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}