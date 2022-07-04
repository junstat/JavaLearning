package Q0199.Q0145BinaryTreePostorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
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
