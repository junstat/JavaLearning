package Q0099.Q0020ValidParentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

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
