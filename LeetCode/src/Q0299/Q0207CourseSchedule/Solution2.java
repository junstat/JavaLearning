package Q0299.Q0207CourseSchedule;

import java.util.ArrayList;
import java.util.List;

/*
    DFS
    For DFS, in each visit, we start from a node and keep visiting its neighbors, if at a time we return to a visited
    node, there is a cycle. Otherwise, start again from another unvisited node and repeat this process. We use todo
    and done for nodes to visit and visited nodes.
 */
public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = buildGraph(numCourses, prerequisites);
        boolean[] todo = new boolean[numCourses], done = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!done[i] && !acylic(g, todo, done, i)) return false;
        }
        return true;
    }

    private boolean acylic(List<List<Integer>> g, boolean[] todo, boolean[] done, int node) {
        if (todo[node]) return false;
        if (done[node]) return true;

        todo[node] = done[node] = true;
        for (int v : g.get(node)) {
            if (!acylic(g, todo, done, v)) return false;
        }
        todo[node] = false;
        return true;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        for (int[] p : prerequisites)
            g.get(p[1]).add(p[0]);
        return g;
    }
}
