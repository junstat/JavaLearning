package Q0199.Q0144BinaryTreePreorderTraversal.solution1;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<Integer>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    void dfs(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }
}
