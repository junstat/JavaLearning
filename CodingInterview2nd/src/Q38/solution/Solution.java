package Q38.solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    ArrayList<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    char[] s;
    boolean[] visited;

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return ans;
        s = str.toCharArray();
        Arrays.sort(s);
        visited = new boolean[s.length];
        dfs();
        return ans;
    }

    void dfs() {
        if (cur.length() == s.length) ans.add(cur.toString());
        else {
            for (int i = 0; i < s.length; i++) {
                if (visited[i] || i > 0 && s[i] == s[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                cur.append(s[i]);
                dfs();
                visited[i] = false;
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}