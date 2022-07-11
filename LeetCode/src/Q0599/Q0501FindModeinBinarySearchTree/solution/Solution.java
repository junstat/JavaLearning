package Q0599.Q0501FindModeinBinarySearchTree.solution;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 先序递归遍历，判断与前驱结点是否相同
public class Solution {
    List<Integer> ans = new ArrayList<>();
    TreeNode pre = null;
    int curTimes = 1, maxTimes = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};
        inOrder(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (pre != null) curTimes = (root.val == pre.val) ? curTimes + 1 : 1;
        if (curTimes == maxTimes) ans.add(root.val);
        else if (curTimes > maxTimes) {
            ans.clear();
            ans.add(root.val);
            maxTimes = curTimes;
        }
        pre = root;
        inOrder(root.right);
    }
}