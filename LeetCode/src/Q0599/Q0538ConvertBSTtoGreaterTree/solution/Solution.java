package Q0599.Q0538ConvertBSTtoGreaterTree.solution;

import DataStructure.TreeNode;

public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        root.val = (sum += root.val);
        convertBST(root.left);
        return root;
    }
}
