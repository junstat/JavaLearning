package Q0799.Q0784LetterCasePermutation.solution1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    char[] s;
    int n;

    public List<String> letterCasePermutation(String ss) {
        s = ss.toCharArray();
        n = s.length;
        dfs(0);
        return ans;
    }

    void dfs(int u) {
        if (u == n) {
            ans.add(new String(s));
            return;
        }
        if (s[u] >= '0' && s[u] <= '9') {
            dfs(u + 1);
            return;
        }
        s[u] = Character.toLowerCase(s[u]);
        dfs(u + 1);
        s[u] = Character.toUpperCase(s[u]);
        dfs(u + 1);
    }
}