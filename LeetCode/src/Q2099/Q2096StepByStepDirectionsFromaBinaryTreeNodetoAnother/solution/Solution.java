package Q2099.Q2096StepByStepDirectionsFromaBinaryTreeNodetoAnother.solution;

import DataStructure.TreeNode;

public class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s = new StringBuilder(), d = new StringBuilder();
        dfs(root, startValue, s);
        dfs(root, destValue, d);
        int m = s.length(), n = d.length(), i = 0;
        for (; i < Math.min(m, n) && s.charAt(m - 1 - i) == d.charAt(n - 1 - i); i++) ;
        int uLen = m - i;
        return new String(new char[uLen]).replace("\0", "U") + d.reverse().substring(i);
    }

    boolean dfs(TreeNode root, int t, StringBuilder ans) {
        if (root.val == t) return true;
        if (root.left != null && dfs(root.left, t, ans)) ans.append("L");
        else if (root.right != null && dfs(root.right, t, ans)) ans.append("R");
        return ans.length() > 0;
    }
}