package Q0299.Q0207CourseSchedule.solution1;

import java.util.ArrayList;
import java.util.List;

/*
    This problem is equivalent to detecting a cycle in the directed graph represented by prerequisites. Both BFS and
    DFS can be used to solve it using the idea of topological sort. Since pair<int, int> is inconvenient for
    implementing graph algorithms, we first transform it to the adjacency-list representation. If course u is a
    prerequisite of course v, then the adjacency list of u will contain v.

    BFS
    BFS uses the indegrees of each node. We will first try to find a node with 0 indegree. If we fail to do so, there
    must be a cycle in the graph and we return false. Otherwise we set its indegree to be -1 to prevent from visiting
    it again and reduce the indegrees of its neighbors by 1. This process will be repeated for n (number of nodes) times.
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = buildGraph(numCourses, prerequisites);
        List<Integer> degrees = computerInDegrees(g);
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++)
                if (degrees.get(j) == 0) break; // 找到了入度为0的顶点，作为遍历的起点
            if (j == numCourses) return false;  // 没有找到入度为0的顶点
            degrees.set(j, degrees.get(j) - 1);
            for (int v : g.get(j)) degrees.set(v, degrees.get(v) - 1);
        }
        return true;
    }

    /*
        [1, 0] To take course 1 you should have finished course 0, 0 -> 1.
        对于 p=prerequisites[i] 中的数对，边的方向是 p[1] -> p[0]
        使用邻接表的方式存储图
     */
    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        for (int[] p : prerequisites)
            g.get(p[1]).add(p[0]); // p[1] -> p[0]
        return g;
    }

    // 计算上面构建的图结构中，每个点的入度
    List<Integer> computerInDegrees(List<List<Integer>> g) {
        List<Integer> degrees = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) degrees.add(0);
        for (List<Integer> adj : g) {
            for (int v : adj) {
                degrees.set(v, degrees.get(v) + 1);
            }
        }
        return degrees;
    }
}
