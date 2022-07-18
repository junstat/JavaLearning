package Q0799.Q0735AsteroidCollision.solution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] asteroidCollision(int[] ats) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int t : ats) {
            boolean ok = true;
            while (ok && !d.isEmpty() && d.peekLast() > 0 && t < 0) {
                int a = d.peekLast(), b = -t;
                if (a <= b) d.pollLast();
                if (a >= b) ok = false;
            }
            if (ok) d.addLast(t);
        }
        int sz = d.size();
        int[] ans = new int[sz];
        while (!d.isEmpty()) ans[--sz] = d.pollLast();
        return ans;
    }
}
