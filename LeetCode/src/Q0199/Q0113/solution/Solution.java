package Q0199.Q0113.solution;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> paths = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int t) {
        findPaths(root, t);
        return paths;
    }

    void findPaths(TreeNode root, int t) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && t == root.val)
            paths.add(new ArrayList<>(path));
        findPaths(root.left, t - root.val);
        findPaths(root.right, t - root.val);
        path.remove(path.size() - 1);
    }
}
