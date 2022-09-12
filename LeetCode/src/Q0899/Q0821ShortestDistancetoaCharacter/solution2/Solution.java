package Q0899.Q0821ShortestDistancetoaCharacter.solution2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                d.addLast(i);
                ans[i] = 0;
            }
        }
        int[] dirs = new int[]{-1, 1};
        while (!d.isEmpty()) {
            int t = d.pollFirst();
            for (int di : dirs) {
                int ne = t + di;
                if (ne >= 0 && ne < n && ans[ne] == -1) {
                    ans[ne] = ans[t] + 1;
                    d.addLast(ne);
                }
            }
        }
        return ans;
    }
}
