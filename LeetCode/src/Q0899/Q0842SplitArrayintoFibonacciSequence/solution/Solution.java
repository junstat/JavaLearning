package Q0899.Q0842SplitArrayintoFibonacciSequence.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> ans;
    char[] cs;

    public List<Integer> splitIntoFibonacci(String num) {
        ans = new ArrayList<>();
        cs = num.toCharArray();
        dfs(0);
        return ans;
    }

    boolean dfs(int u) {
        // 边界条件判断，如果截取完了，并且ans长度大于等于3，表示找到了一个组合
        if (u == cs.length && ans.size() >= 3) return true;
        for (int i = u; i < cs.length; i++) {
            // 两位以上的数字不能以0开头
            if (cs[u] == '0' && i > u) break;
            // 截取字符串转化为数字
            long num = subDigit(u, i + 1);
            // 如果截取的数字大于int的最大值，则终止截取
            if (num > Integer.MAX_VALUE) break;
            int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) break;
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                if (dfs(i + 1)) return true;
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }

    long subDigit(int start, int end) {
        long ans = 0;
        for (int i = start; i < end; i++) {
            ans = ans * 10 + cs[i] - '0';
        }
        return ans;
    }
}
