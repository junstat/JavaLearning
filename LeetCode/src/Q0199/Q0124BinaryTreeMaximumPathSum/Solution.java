package Q0199.Q0124BinaryTreeMaximumPathSum;

import DataStructure.TreeNode;

/*
    Ideas:
    A path from start to end, goes up on the tree for 0 or more steps, then goes down for 0 or more steps. Once it
    goes down, it can't go up. Each path has a highest node, which is also the lowest common ancestor of all other
    nodes on the path.

    A recursive method maxPathDown(TreeNode node)
        (1) computes the maximum path sum with highest node is the input node, update maximum if necessary
        (2) returns the maximum sum of the path that can be extended to input node's parent.
 */
public class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return result;
    }

    int maxPathDown(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, maxPathDown(root.left));
        int right = Math.max(0, maxPathDown(root.right));
        result = Math.max(result, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
