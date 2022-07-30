package Q0799.Q0739DailyTemperatures.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && A[s.peekLast()] <= A[i]) s.pollLast();
            ans[i] = s.isEmpty() ? 0 : s.peekLast() - i;
            s.addLast(i);
        }
        return ans;
    }
}