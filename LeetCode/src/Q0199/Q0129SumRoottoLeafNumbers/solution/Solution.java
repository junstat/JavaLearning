package Q0199.Q0129SumRoottoLeafNumbers.solution;

import DataStructure.TreeNode;

// DFS
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumAux(root, 0);
    }

    private int sumAux(TreeNode root, int res) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return res * 10 + root.val;
        return sumAux(root.left, res * 10 + root.val) + sumAux(root.right, res * 10 + root.val);
    }
}