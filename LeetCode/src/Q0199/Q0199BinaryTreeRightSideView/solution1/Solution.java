package Q0199.Q0199BinaryTreeRightSideView.solution1;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        rightSideView(root, 0);
        return ans;
    }

    void rightSideView(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == ans.size()) ans.add(root.val);

        rightSideView(root.right, depth + 1);
        rightSideView(root.left, depth + 1);
    }
}