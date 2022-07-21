package Q0199.Q0145BinaryTreePostorderTraversal.solution1;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return result;
    }

    void dfs(TreeNode root) {
        if (root != null) {
            dfs(root.left);
            dfs(root.right);
            result.add(root.val);
        }
    }
}
