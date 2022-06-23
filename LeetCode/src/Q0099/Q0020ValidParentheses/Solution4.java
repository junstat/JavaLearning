package Q0099.Q0020ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution4 {
    public boolean isValid(String s) {
        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int u = c - '0';
            if (c == '(' || c == '{' || c == '[') {
                d.addLast(u);
            } else {
                if (!d.isEmpty() && Math.abs(d.peekLast() - u) <= 2) {
                    d.pollLast();
                } else {
                    return false;
                }
            }
        }
        return d.isEmpty();
    }
}