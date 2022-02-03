package Q0199.Q0140WordBreakII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    DFS
 */
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // used HashMap to save the previous results to prune duplicated branches
        return backtracking(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> backtracking(String s, List<String> wordDict, Map<String, List<String>> mem) {
        if (mem.containsKey(s)) return mem.get(s);
        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) result.add(word);
                else
                    for (String sub : backtracking(next, wordDict, mem))
                        result.add(word + " " + sub);
            }
        }
        mem.put(s, result);
        return result;
    }
}
