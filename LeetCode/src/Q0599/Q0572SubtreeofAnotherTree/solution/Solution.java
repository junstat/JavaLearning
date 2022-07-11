package Q0599.Q0572SubtreeofAnotherTree.solution;

import DataStructure.TreeNode;

public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return isSameTree(s, t) || (s != null && (isSubtree(s.left, t) || isSubtree(s.right, t)));
    }

    boolean isSameTree(TreeNode s, TreeNode t) {
        return (s == null && t == null) || (s != null && t != null && s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
    }
}
