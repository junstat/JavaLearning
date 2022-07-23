package Q0199.Q173BinarySearchTreeIterator.inorder;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();
    Deque<TreeNode> d = new ArrayDeque<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        while (root != null || !d.isEmpty()) {
            // 步骤 1
            while (root != null) {
                d.addLast(root);
                root = root.left;
            }

            // 步骤 2
            root = d.pollLast();
            ans.add(root.val);

            // 步骤 3
            root = root.right;
        }
        return ans;
    }
}