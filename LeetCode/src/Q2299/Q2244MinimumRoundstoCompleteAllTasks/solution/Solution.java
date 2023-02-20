package Q2299.Q2244MinimumRoundstoCompleteAllTasks.solution;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : tasks) cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        int ans = 0;
        for (int x : cnt.values()) {
            if (x == 1) return -1;
            else if (x == 2) ans++;
            else if (x % 3 == 0) ans += x / 3;
            else ans += x / 3 + 1;
        }
        return ans;
    }
}
