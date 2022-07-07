package Q0299.Q0227BasicCalculatorII.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (c >= '0' && c <= '9') {
                n = n * 10 + c - '0';
                continue;
            }
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop() * n);
            else if (op == '/') stack.push(stack.pop() / n);
            op = c;
            n = 0;
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();
        return result;
    }
}
