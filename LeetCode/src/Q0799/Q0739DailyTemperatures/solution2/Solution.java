package Q0799.Q0739DailyTemperatures.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int[] dailyTemperatures(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && A[s.peekLast()] < A[i]) {
                ans[s.peekLast()] = i - s.peekLast();
                s.pollLast();
            }
            s.addLast(i);
        }
        return ans;
    }
}