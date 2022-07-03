package Q0199.Q0140WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    DFS
 */
public class Solution {
    List<String> dict;
    // used HashMap to save the previous results to prune duplicated branches
    Map<String, List<String>> mem = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = wordDict;
        return dfs(s);
    }

    List<String> dfs(String s) {
        if (mem.containsKey(s)) return mem.get(s);
        List<String> result = new ArrayList<>();
        for (String word : dict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) result.add(word);
                else
                    for (String sub : dfs(next))
                        result.add(word + " " + sub);
            }
        }
        mem.put(s, result);
        return result;
    }
}
