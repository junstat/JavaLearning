package Q0099.Q0095.solution1;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
  利用BST的中序遍历为递增序：遍历 1 ~ n，工作变量为i。设genTrees(int start, int end) 为构造树的方法
  若i为根结点，则 left =genTrees(1, i - 1); right = genTrees(i + 1, n)。
*/
public class Solution {

    public List<TreeNode> generateTrees(int n) {
        return genTrees(1, n);
    }

    private List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<>();

        if (start > end) {
            list.add(null);
            return list;
        }

        if (start == end) {
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}