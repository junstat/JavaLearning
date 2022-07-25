package Q0699.Q0649Dota2Senate.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String predictPartyVictory(String s) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] cnt = new int[2], ban = new int[2];
        for (char c : s.toCharArray()) {
            int x = c == 'R' ? 1 : 0;
            cnt[x]++;
            q.addLast(x);
        }
        while (cnt[0] != 0 && cnt[1] != 0) {
            int x = q.pollFirst();
            if (ban[x] != 0) {
                ban[x]--;
                cnt[x]--;
            } else {
                ban[1 - x]++;
                q.addLast(x);
            }
        }
        return cnt[1] != 0 ? "Radiant" : "Dire";
    }
}
