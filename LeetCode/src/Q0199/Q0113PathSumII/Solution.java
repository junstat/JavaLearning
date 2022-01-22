package Q0199.Q0113PathSumII;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    a typical backtracking problem.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        findPaths(root, targetSum, path, paths);
        return paths;
    }

    private void findPaths(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> paths) {
        if (root == null) return;
        path.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val)
            paths.add(new LinkedList<>(path));
        findPaths(root.left, targetSum - root.val, path, paths);
        findPaths(root.right, targetSum - root.val, path, paths);
        path.remove(path.size() - 1);
    }
}
