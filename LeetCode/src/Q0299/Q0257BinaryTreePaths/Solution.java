package Q0299.Q0257BinaryTreePaths;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
    DFS
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null) binaryTreePathsAux(root, "", answer);
        return answer;
    }

    private void binaryTreePathsAux(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null) answer.add(path + root.val);
        if (root.left != null) binaryTreePathsAux(root.left, path + root.val + "->", answer);
        if (root.right != null) binaryTreePathsAux(root.right, path + root.val + "->", answer);
    }
}
