package Q0599.Q0559MaximumDepthofNAryTree.solution1;

import Q0599.Q0559MaximumDepthofNAryTree.Node;

public class Solution {
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans, maxDepth(node));
        }
        return ans + 1;
    }
}
