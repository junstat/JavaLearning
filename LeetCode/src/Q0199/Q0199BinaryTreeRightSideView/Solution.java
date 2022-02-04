package Q0199.Q0199BinaryTreeRightSideView;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    思路: 递归
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode root, List<Integer> result, int curDepth) {
        if (root == null) return;

        if (curDepth == result.size()) result.add(root.val);

        rightSideView(root.right, result, curDepth + 1);
        rightSideView(root.left, result, curDepth + 1);
    }
}
