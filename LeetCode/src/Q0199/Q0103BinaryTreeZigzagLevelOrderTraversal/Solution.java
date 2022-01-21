package Q0199.Q0103BinaryTreeZigzagLevelOrderTraversal;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    /*
       1. O(n) solution by using LinkedList along with ArrayList.
        So insertion in the inner list and outer list are both O(1),
       2. Using DFS and creating new lists when needed.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root, result, 0);
        return result;
    }

    private void travel(TreeNode curr, List<List<Integer>> result, int level) {
        if (curr == null) return;
        if (result.size() <= level) result.add(new LinkedList<>());

        List<Integer> collection = result.get(level);
        if (level % 2 == 0) collection.add(curr.val);  // level为偶数，尾插
        else collection.add(0, curr.val);  // level 为奇数，头插

        travel(curr.left, result, level + 1);
        travel(curr.right, result, level + 1);
    }
}

/*
   中文社区，另解: 1. 正常层次遍历；2. 遍历1. 结果, level为奇数，reverse.
 */
