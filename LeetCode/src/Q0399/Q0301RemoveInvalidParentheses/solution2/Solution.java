package Q0399.Q0301RemoveInvalidParentheses.solution2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    Set<String> set = new HashSet<>();
    int n, max, len;
    String s;

    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') r++;
        }
        max = Math.min(l, r);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    /**
     * dfs爆搜
     *
     * @param u:     当前处理到s的位置(下标)
     * @param cur:   局部结果
     * @param score: 左括号、右括号得分
     */
    void dfs(int u, String cur, int score) {
        if (score < 0 || score > max) return;
        if (u == n) {
            if (score == 0 && cur.length() >= len) {
                if (cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(u);
        if (c == '(') {
            dfs(u + 1, cur + String.valueOf(c), score + 1);
            dfs(u + 1, cur, score);
        } else if (c == ')') {
            dfs(u + 1, cur + String.valueOf(c), score - 1);
            dfs(u + 1, cur, score);
        } else {
            dfs(u + 1, cur + String.valueOf(c), score);
        }
    }
}