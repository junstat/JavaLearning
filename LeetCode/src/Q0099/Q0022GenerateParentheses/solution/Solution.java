package Q0099.Q0022GenerateParentheses.solution;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> ans = new ArrayList<>();
    int max, len;

    public List<String> generateParenthesis(int n) {
        max = n;
        len = 2 * n;
        dfs(0, 0, "");
        return ans;
    }

    void dfs(int i, int score, String path) {
        if (i == len) {
            if (score == 0) ans.add(path);
        } else {
            if (score + 1 <= max) dfs(i + 1, score + 1, path + "(");
            if (score - 1 >= 0) dfs(i + 1, score - 1, path + ")");
        }
    }
}