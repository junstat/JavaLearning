package Q0099.Q0095UniqueBinarySearchTreesII;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees II.
public class Solution2 {
    List<TreeNode>[][] memo;

    public List<TreeNode> generateTrees(int n) {
        memo = new ArrayList[n + 1][n + 1];
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }

        if (memo[start][end] != null) return memo[start][end];
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = build(start, i - 1);
            List<TreeNode> right = build(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        }
        memo[start][end] = trees;
        return trees;
    }
}
