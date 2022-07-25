package Q26.solution;

import DataStructure.TreeNode;

public class Solution {
    public boolean HasSubtree(TreeNode s, TreeNode t) {
        return isSubTree(s, t);
    }

    boolean isSubTree(TreeNode s, TreeNode t) {
        boolean result = false;
        if (s != null && t != null) {
            if (s.val == t.val)
                result = isSameTree(s, t);
            if (!result)
                result = isSubTree(s.left, t);
            if (!result)
                result = isSubTree(s.right, t);
        }
        return result;
    }

    boolean isSameTree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
