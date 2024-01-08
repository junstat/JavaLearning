package Q0199.Q0102.solution2;

import DataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    BFS: Breadth First Search, 广度优先搜索
    从某个顶点A出发，在访问了A之后依次访问A的各个未曾访问过的邻接点，然后分别从这些邻接点出发依次访问它们的邻接点。
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderAux(res, root, 0);
        return res;
    }

    private void levelOrderAux(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size())
            res.add(new LinkedList<Integer>());
        res.get(height).add(root.val);
        levelOrderAux(res, root.left, height + 1);
        levelOrderAux(res, root.right, height + 1);
    }
}
