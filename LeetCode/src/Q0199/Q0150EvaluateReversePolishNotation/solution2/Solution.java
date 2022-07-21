package Q0199.Q0150EvaluateReversePolishNotation.solution2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int evalRPN(String[] ts) {
        Deque<Integer> d = new ArrayDeque<>();
        for (String s : ts) {
            if ("+-*/".contains(s)) {
                int b = d.pollLast(), a = d.pollLast();
                d.addLast(calc(a, b, s));
            } else {
                d.addLast(Integer.parseInt(s));
            }
        }
        return d.pollLast();
    }

    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }
}