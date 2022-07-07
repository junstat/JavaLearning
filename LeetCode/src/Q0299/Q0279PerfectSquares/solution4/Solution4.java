package Q0299.Q0279PerfectSquares.solution4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
    BFS
 */
public class Solution4 {
    public int numSquares(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        Queue<Integer> qu = new LinkedList<>();
        qu.offer(0);
        int level = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                int cur = qu.poll();
                for (int j = 1; cur + j * j <= n; j++) {
                    int temp = cur + j * j;
                    if (temp == n) {
                        return level + 1;
                    }
                    if (!visited.contains(temp)) {
                        qu.offer(temp);
                        visited.add(temp);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
