package Q0699.Q0662MaximumWidthofBinaryTree.solution1;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int maxWidth;

    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> levelHeads = new ArrayList<>(); // first nodes at each level;
        dfs(root, 1, 0, levelHeads);
        return maxWidth;
    }

    private void dfs(TreeNode node, int id, int depth, List<Integer> levelHeads) {
        if (depth >= levelHeads.size()) levelHeads.add(id);   // add first node
        maxWidth = Math.max(maxWidth, id - levelHeads.get(depth) + 1);

        if (node.left != null)
            dfs(node.left, id * 2, depth + 1, levelHeads);
        if (node.right != null)
            dfs(node.right, id * 2 + 1, depth + 1, levelHeads);
    }
}
