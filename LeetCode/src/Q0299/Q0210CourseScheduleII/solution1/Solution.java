package Q0299.Q0210CourseScheduleII.solution1;

// Similar to Course Schedule, during the process of visiting the nodes, store them in order to a vector. In DFS, you
// may need an additional reverse.

import java.util.ArrayList;
import java.util.List;

// BFS
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = buildGraph(numCourses, prerequisites);
        List<Integer> degrees = computerInDegrees(g);
        int[] order = new int[numCourses];
        int insertIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            int j = 0;
            for (; j < numCourses; j++)
                if (degrees.get(j) == 0) {
                    order[insertIndex++] = j;
                    break;
                }
            if (j == numCourses) return new int[]{};
            degrees.set(j, degrees.get(j) - 1);
            for (int v : g.get(j)) degrees.set(v, degrees.get(v) - 1);
        }
        return order;
    }

    private List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        for (int[] p : prerequisites)
            g.get(p[1]).add(p[0]);
        return g;
    }

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
