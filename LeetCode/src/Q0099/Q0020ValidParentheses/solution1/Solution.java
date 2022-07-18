package Q0099.Q0020ValidParentheses.solution1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean isValid(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') brackets.push(c);
            else if (c == ')') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '(') brackets.pop();
                else return false;
            } else if (c == ']') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '[') brackets.pop();
                else return false;
            } else if (c == '}') {
                if (brackets.isEmpty()) return false;
                else if (brackets.peek() == '{') brackets.pop();
                else return false;
            }
        }
        return brackets.isEmpty();
    }
}
