package Q0499.Q0429NAryTreeLevelOrderTraversal.solution;

import Q0499.Q0429NAryTreeLevelOrderTraversal.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                curLevel.add(node.val);
                for (Node child : node.children) queue.add(child);
            }
            result.add(curLevel);
        }
        return result;
    }
}