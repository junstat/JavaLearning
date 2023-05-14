package Q1099.Q1003CheckIfWordIsValidAfterSubstitutions.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (q.isEmpty() || q.pollLast() != 'b') return false;
                if (q.isEmpty() || q.pollLast() != 'a') return false;
            } else {
                q.addLast(c);
            }
        }
        return q.isEmpty();
    }
}
