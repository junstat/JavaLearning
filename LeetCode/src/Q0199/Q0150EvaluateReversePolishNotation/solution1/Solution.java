package Q0199.Q0150EvaluateReversePolishNotation.solution1;

public class Solution {
    public int evalRPN(String[] ts) {
        int[] d = new int[ts.length];
        int hh = 0, tt = -1;
        for (String s : ts) {
            if ("+-*/".contains(s)) {
                int b = d[tt--], a = d[tt--];
                d[++tt] = calc(a, b, s);
            } else {
                d[++tt] = Integer.parseInt(s);
            }
        }
        return d[tt];
    }

    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }
}
