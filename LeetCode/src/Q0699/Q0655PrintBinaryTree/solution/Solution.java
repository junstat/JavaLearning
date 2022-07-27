package Q0699.Q0655PrintBinaryTree.solution;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int rows = root == null ? 1 : getHeight(root);
        int cols = (int) (Math.pow(2, rows) - 1);
        List<String> cur = new ArrayList<>();
        for (int i = 0; i < cols; i++) cur.add("");
        for (int i = 0; i < rows; i++) ans.add(new ArrayList<>(cur));
        populateResult(root, 0, rows, 0, cols - 1);
        return ans;
    }

    void populateResult(TreeNode root, int r, int totR, int i, int j) {
        if (root == null || r == totR) return;
        ans.get(r).set((i + j) / 2, String.valueOf(root.val));
        populateResult(root.left, r + 1, totR, i, ((i + j) / 2) - 1);
        populateResult(root.right, r + 1, totR, ((i + j) / 2) + 1, j);
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int l = getHeight(root.left), r = getHeight(root.right);
        return 1 + Math.max(l, r);
    }
}
