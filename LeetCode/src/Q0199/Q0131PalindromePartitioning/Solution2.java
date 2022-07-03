package Q0199.Q0131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        // f[i][j]代表[i, j]这一段是否为回文串
        boolean[][] f = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                // 当[i, j]只有一个字符时，必然是回文串
                if (i == j) f[i][j] = true;
                else {
                    // 当[i, j]长度为2时，满足cs[i] == cs[j]即为回文串
                    if (j - i + 1 == 2) f[i][j] = cs[i] == cs[j];
                    else f[i][j] = cs[i] == cs[j] && f[i + 1][j - 1];
                }
            }
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dfs(s, 0, ans, cur, f);
        return ans;
    }

    void dfs(String s, int u, List<List<String>> ans, List<String> cur, boolean[][] f) {
        int n = s.length();
        if (u == n) ans.add(new ArrayList<>(cur));
        for (int i = u; i < n; i++) {
            if (f[u][i]) {
                cur.add(s.substring(u, i + 1));
                dfs(s, i + 1, ans, cur, f);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
