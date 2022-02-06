package Q0299.Q0224BasicCalculator;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Principle:
    1. (Sign before '+'/'-') = (This context sign);
    2. (Sign after '+'/'-') = (This context sign) * (1 or -1);

    Algorithm:
     1) Start from +1 sign and scan s from left to right;
     2) if c == digit: This number = Last digit * 10 + This digit;
     3) if c == '+': Add num to result before this sign; This sign = Last context sign * 1; clear num;
     4) if c == '-': Add num to result before this sign; This sign = Last context sign * -1; clear num;
     5) if c == '(': Push this context sign to stack;
     6) if c == ')': Pop this context and we come back to last context;
     7) Add the last num. This is because we only add number after '+' / '-'.
 */
public class Solution {

    public int calculate(String s) {
        if (s == null) return 0;

        int result = 0;
        int num = 0;
        int sign = 1;

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(sign);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') {
                num = 10 * num + c - '0';
            } else if (c == '+' || c == '-') {
                result += sign * num;
                sign = stack.peek() * (c == '+' ? 1 : -1);
                num = 0;
            } else if (c == '(') {
                stack.push(sign);
            } else if (c == ')') {
                stack.pop();
            }
        }
        result += sign * num;
        return result;
    }
}
