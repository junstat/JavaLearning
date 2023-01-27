package Q0899.Q0841KeysandRooms.solution1;

import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        seen.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            int roomIndex = queue.poll();
            for (int key : rooms.get(roomIndex)) {
                if (!seen.contains(key)) {
                    seen.add(key);
                    queue.add(key);
                }
            }
        }
        return seen.size() == rooms.size();
    }
}
