package Q28.solution2;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean isSymmetrical(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null || a.val != b.val) return false;
            q.add(a.left);
            q.add(b.right);
            q.add(a.right);
            q.add(b.left);
        }
        return true;
    }
}
