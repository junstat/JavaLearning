package Q0699.Q0637AverageofLevelsinBinaryTree.solution;

import DataStructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        if (root == null) return ans;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            double cnt = q.size(), sum = 0;
            for (int i = 0; i < cnt; i++) {
                TreeNode cur = q.pollFirst();
                sum += cur.val;
                if (cur.left != null) q.addLast(cur.left);
                if (cur.right != null) q.addLast(cur.right);
            }
            ans.add(sum / cnt);
        }
        return ans;
    }
}
