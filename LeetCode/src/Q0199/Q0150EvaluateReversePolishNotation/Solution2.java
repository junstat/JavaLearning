package Q0199.Q0150EvaluateReversePolishNotation;

import java.util.ArrayDeque;
import java.util.Deque;

/*
   用数组代替栈
 */
public class Solution2 {
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