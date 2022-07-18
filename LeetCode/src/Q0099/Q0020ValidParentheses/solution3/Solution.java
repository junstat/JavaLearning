package Q0099.Q0020ValidParentheses.solution3;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ('(' == c) stack.push(')');
            else if ('[' == c) stack.push(']');
            else if ('{' == c) stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
