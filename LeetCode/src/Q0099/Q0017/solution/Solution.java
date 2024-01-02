package Q0099.Q0017.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<Character, char[]> map = new HashMap<Character, char[]>() {{
        put('2', new char[]{'a', 'b', 'c'});
        put('3', new char[]{'d', 'e', 'f'});
        put('4', new char[]{'g', 'h', 'i'});
        put('5', new char[]{'j', 'k', 'l'});
        put('6', new char[]{'m', 'n', 'o'});
        put('7', new char[]{'p', 'q', 'r', 's'});
        put('8', new char[]{'t', 'u', 'v'});
        put('9', new char[]{'w', 'x', 'y', 'z'});
    }};
    String ds;
    int n;
    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();

    public List<String> letterCombinations(String _ds) {
        ds = _ds;
        n = ds.length();
        if (n == 0) return ans;
        dfs(0);
        return ans;
    }

    void dfs(int start) {
        if (start == n) {
            ans.add(cur.toString());
            return;
        }
        char num = ds.charAt(start);
        for (char c : map.get(num)) {
            cur.append(c);
            dfs(start + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}