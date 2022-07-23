package Q0599.Q0559MaximumDepthofNAryTree.solution2;

import Q0599.Q0559MaximumDepthofNAryTree.Node;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        Deque<Node> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                Node t = d.pollFirst();
                for (Node node : t.children) {
                    d.addLast(node);
                }
            }
            ans++;
        }
        return ans;
    }
}
