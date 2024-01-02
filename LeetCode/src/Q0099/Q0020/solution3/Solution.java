package Q0099.Q0020.solution3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public boolean isValid(String s) {
        Deque<Character> d = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '(') d.addLast(')');
            else if (c == '[') d.addLast(']');
            else if (c == '{') d.addLast('}');
            else if (d.isEmpty() || c != d.pollLast()) return false;
        }
        return d.isEmpty();
    }
}