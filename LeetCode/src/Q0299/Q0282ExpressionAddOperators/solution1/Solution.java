package Q0299.Q0282ExpressionAddOperators.solution1;

import java.util.ArrayList;
import java.util.List;

/*
    This problem has a lot of edge cases to be considered:

    overflow: we use a long type once it is larger than Integer.MAX_VALUE or minimum, we get over it.
    0 sequence: because we can't have numbers with multiple digits started with zero, we have to deal with it too.
    a little trick is that we should save the value that is to be multiplied in the next recursion.
 */
public class Solution {
    private List<String> result;
    private String num;
    private int target;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        this.num = num;
        this.target = target;
        if (num == null || num.length() == 0) return result;
        helper("", 0, 0, 0);
        return result;
    }

    public void helper(String path, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                result.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {  // 表达式起头位置不添加符号
                helper(path + cur, i + 1, cur, cur);
            } else {
                helper(path + "+" + cur, i + 1, eval + cur, cur);
                helper(path + "-" + cur, i + 1, eval - cur, -cur);
                helper(path + "*" + cur, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
