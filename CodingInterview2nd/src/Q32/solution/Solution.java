package Q32.solution;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.pollFirst();
            ans.add(cur.val);
            if (cur.left != null) q.addLast(cur.left);
            if (cur.right != null) q.addLast(cur.right);
        }
        return ans;
    }
}