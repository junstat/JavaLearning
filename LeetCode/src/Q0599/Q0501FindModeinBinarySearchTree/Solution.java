package Q0599.Q0501FindModeinBinarySearchTree;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 先序递归遍历，判断与前驱结点是否相同
public class Solution {
    Integer prev = null;
    int count = 1;
    int max = 0;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new ArrayList<>();
        traverse(root, list);

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
        return res;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
    }
}