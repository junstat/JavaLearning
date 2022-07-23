package Q0599.Q0590NAryTreePostorderTraversal.solution1;

import Q0599.Q0559MaximumDepthofNAryTree.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;
    }

    void dfs(Node root) {
        if (root == null) return;
        for (Node node : root.children) dfs(node);
        ans.add(root.val);
    }
}