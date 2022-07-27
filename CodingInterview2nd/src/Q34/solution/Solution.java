package Q34.solution;

import DataStructure.TreeNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> cur = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int t) {
        pathSum(root, t);
        return ans;
    }

    void pathSum(TreeNode root, int t) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null && root.val == t) ans.add(new ArrayList<>(cur));
        pathSum(root.left, t - root.val);
        pathSum(root.right, t - root.val);
        cur.remove(cur.size() - 1);
    }
}