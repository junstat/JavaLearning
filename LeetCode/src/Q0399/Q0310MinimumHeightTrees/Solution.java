package Q0399.Q0310MinimumHeightTrees;

import org.junit.Test;

import java.util.*;

/*
    Our problem want us to find the minimum height trees and return their root labels. First we can think about a
    simple case -- a path graph.

    For a path graph of n nodes, find the minimum height trees is trivial. Just designate the middle point(s) as roots.

    Despite its triviality, let design a algorithm to find them.

    Suppose we don't know n, nor do we have random access of the nodes. We have to traversal. It is very easy to get
    the idea of two pointers. One from each end and move at the same speed. When they meet or they are one step away,
     (depends on the parity of n), we have the roots we want.

    This gives us a lot of useful ideas to crack our real problem.

    For a tree we can do some thing similar. We start from every end, by end we mean vertex of degree 1 (aka leaves).
    We let the pointers move the same speed. When two pointers meet, we keep only one of them, until the last two
    pointers meet or one step away we then find the roots.

    It is easy to see that the last two pointers are from the two ends of the longest path in the graph.

    The actual implementation is similar to the BFS topological sort. Remove the leaves, update the degrees of inner
    vertexes. Then remove the new leaves. Doing so level by level until there are 2 or 1 nodes left. What's left is
    our answer!

    The time complexity and space complexity are both O(n).

    Note that for a tree we always have V = n, E = n-1.
 */
public class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        List<Set<Integer>> adj = new ArrayList<>(n);    // 保存边
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 把度为1的顶点收集起来
        for (int i = 0; i < n; i++) if (adj.get(i).size() == 1) result.add(i);

        while (n > 2) {
            n -= result.size();
            List<Integer> curLeaves = new ArrayList<>();
            for (Integer i : result) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);   // 抹掉度为1的点
                if (adj.get(j).size() == 1) curLeaves.add(j); // 重新收集度为1的顶点
            }
            result = curLeaves;
        }
        return result;
    }
}
