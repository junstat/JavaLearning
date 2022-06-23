package Q0099.Q0017LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String[]> map = new HashMap<Character, String[]>() {{
        put('2', new String[]{"a", "b", "c"});
        put('3', new String[]{"d", "e", "f"});
        put('4', new String[]{"g", "h", "i"});
        put('5', new String[]{"j", "k", "l"});
        put('6', new String[]{"m", "n", "o"});
        put('7', new String[]{"p", "q", "r", "s"});
        put('8', new String[]{"t", "u", "v"});
        put('9', new String[]{"w", "x", "y", "z"});
    }};

    public List<String> letterCombinations(String ds) {
        int n = ds.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        StringBuilder sb = new StringBuilder();
        dfs(ds, 0, n, sb, ans);
        return ans;
    }

    void dfs(String ds, int i, int n, StringBuilder sb, List<String> ans) {
        if (i == n) {
            ans.add(sb.toString());
            return;
        }
        char key = ds.charAt(i);
        String[] all = map.get(key);
        for (String item : all) {
            sb.append(item);
            dfs(ds, i + 1, n, sb, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
