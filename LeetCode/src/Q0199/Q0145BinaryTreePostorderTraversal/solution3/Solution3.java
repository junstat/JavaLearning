package Q0199.Q0145BinaryTreePostorderTraversal.solution3;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    List<Integer> ans = new ArrayList<>();
    TreeNode dump, cur, prev = null;

    public List<Integer> postorderTraversal(TreeNode root) {
        dump = new TreeNode(0, root, null);
        cur = dump;
        while (cur != null) {
            if (cur.left == null) cur = cur.right;
            else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) prev = prev.right;
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    addNodeReverse(cur.left, prev);
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }

    void addNodeReverse(TreeNode from, TreeNode to) {
        reverse(from, to);
        for (TreeNode p = to; p != from; p = p.right) ans.add(p.val);
        ans.add(from.val);
        reverse(to, from);
    }

    void reverse(TreeNode from, TreeNode to) {
        TreeNode prev = from, cur = prev.right, next = cur.right;
        while (prev != to) {
            cur.right = prev;
            prev = cur;
            cur = next;
            next = next.right;
        }
    }
}
