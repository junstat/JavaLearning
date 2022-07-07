package Q0299.Q0236LowestCommonAncestorofaBinaryTree.solution2;

import DataStructure.TreeNode;

import java.util.*;

/*
    BFS:
    To find the lowest common ancestor, we need to find where is p and q and a way to track their ancestors. A parent
    pointer for each node found is good for the job. After we found both p and q, we create a set of p's ancestors.
    Then we travel through q's ancestors, the first one appears in p's is our answer.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        parents.put(root, null);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    parents.put(node.left, node);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    queue.add(node.right);
                }
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }
}
