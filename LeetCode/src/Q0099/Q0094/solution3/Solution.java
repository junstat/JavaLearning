package Q0099.Q0094.solution3;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        List<Integer> result = new ArrayList<>();
        while (cur != null) {
            if (cur.left == null) {     // 1.
                result.add(cur.val);
                cur = cur.right;
            } else {
                // find predecessor
                prev = cur.left;
                while (prev.right != null && prev.right != cur) prev = prev.right;
                if (prev.right == null) {       // 2.a
                    prev.right = cur;
                    cur = cur.left;
                } else {                        // 2.
                    prev.right = null;
                    result.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return result;
    }
}