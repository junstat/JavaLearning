package Q0199.Q0144BinaryTreePreorderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
   先序遍历: 根左右
   method 1: 递归做法
 */
public class Solution1 {
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
