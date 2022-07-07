package Q0299.Q0241DifferentWaystoAddParentheses.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Solution1: 递归
    遍历输入表达式expression，工作变量为char op = expression[i]，若op是运算符，则表达式可在op处断开，成为两个子表达式
    String left = expression[0...i];
    String right = expression[i+1...n];
    递归求解两个子问题，并根据op，遍历子问题的结果，合并到最终的结果。

    示例: expression = "2*3-4*5"
    ways("2*3-4*5")  = ways("2") x(*) ways("3-4*5") U      # x指的是 做笛卡尔积
                       ways("2*3") x(-) ways("4*5") U
                       ways("2*3-4") x(*) ways("5")
                     = {2} x(*) {-17, -5}  <- {-34, -10}
                      U {6} x(-) {20} <- {-14}
                      U {-2, 2} x(*) {5} <- {-10, 10}
                     = {-34, -10, -14, -10, 10}
 */
public class Solution {
    private Map<String, List> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        return ways(expression);
    }

    private List<Integer> ways(String expression) {
        if (memo.containsKey(expression)) return memo.get(expression);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char op = expression.charAt(i);
            // Split the expression by an op
            if (op == '+' || op == '-' || op == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                // Get the solution of left/right sub-expressions
                List<Integer> l = ways(left);
                List<Integer> r = ways(right);

                // Combine the solution
                for (int a : l) {
                    for (int b : r) {
                        ans.add(calc(op, a, b));
                    }
                }
            }
        }

        // Single number, e.g. s = "3"
        if (ans.isEmpty())
            ans.add(Integer.valueOf(expression));

        memo.put(expression, ans);
        return ans;
    }

    private int calc(char op, int a, int b) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}
