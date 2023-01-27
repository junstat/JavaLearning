package Q0899.Q0841KeysandRooms.solution2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<Integer> seen = new HashSet<>();
    List<List<Integer>> rooms;

    public boolean canVisitAllRooms(List<List<Integer>> _rooms) {
        seen.add(0);
        rooms = _rooms;
        dfs(0);
        return seen.size() == rooms.size();
    }

    void dfs(int u) {
        seen.add(u);
        for (int key : rooms.get(u)) {
            if (!seen.contains(key)) dfs(key);
        }
    }
}
