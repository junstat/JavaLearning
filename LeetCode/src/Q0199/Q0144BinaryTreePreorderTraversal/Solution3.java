package Q0199.Q0144BinaryTreePreorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    TreeNode cur, prev = null;
    List<Integer> ans = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        cur = root;
        while (cur != null) {
            if (cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) prev = prev.right;
                if (prev.right == null) {
                    ans.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }
}
