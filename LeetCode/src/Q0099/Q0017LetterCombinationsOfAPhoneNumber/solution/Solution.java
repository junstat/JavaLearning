package Q0099.Q0017LetterCombinationsOfAPhoneNumber.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    List<String> ans = new ArrayList<>();
    StringBuilder cur = new StringBuilder();
    String ds;
    int n;

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
        String letters = map.get(num);
        for (char c : letters.toCharArray()) {
            cur.append(c);
            dfs(start + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}