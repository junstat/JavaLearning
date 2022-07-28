package Q0699.Q0671SecondMinimumNodeInaBinaryTree.solution1;

import DataStructure.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (set.size() < 2) return -1;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}