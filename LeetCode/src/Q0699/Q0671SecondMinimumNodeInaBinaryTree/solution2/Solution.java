package Q0699.Q0671SecondMinimumNodeInaBinaryTree.solution2;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode root) {
        bfs(root);
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

    void bfs(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            set.add(poll.val);
            if (poll.left != null) d.addLast(poll.left);
            if (poll.right != null) d.addLast(poll.right);
        }
    }
}