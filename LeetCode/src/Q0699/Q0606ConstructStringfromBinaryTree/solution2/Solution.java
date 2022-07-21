package Q0699.Q0606ConstructStringfromBinaryTree.solution2;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Set<TreeNode> vis = new HashSet<>();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode t = d.pollLast();
            if (vis.contains(t)) {
                sb.append(")");
            } else {
                d.addLast(t);
                sb.append("(");
                sb.append(t.val);
                if (t.right != null) d.addLast(t.right);
                if (t.left != null) d.addLast(t.left);
                else if (t.right != null) sb.append("()");
                vis.add(t);
            }
        }
        return sb.substring(1, sb.length() - 1);
    }
}