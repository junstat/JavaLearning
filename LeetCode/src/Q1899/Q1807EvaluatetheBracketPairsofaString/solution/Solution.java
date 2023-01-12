package Q1899.Q1807EvaluatetheBracketPairsofaString.solution;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        Map<String, String> map = new HashMap<>();
        for (List<String> line : knowledge) {
            String k = line.get(0);
            String v = line.get(1);
            map.put(k, v);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (cs[i] != '(') {
                ans.append(cs[i]);
                continue;
            }
            StringBuilder last = new StringBuilder();
            for (int j = i + 1; j < n; j++) {
                if (cs[j] == ')') {
                    i = j;
                    break;
                }
                last.append(cs[j]);
            }
            ans.append(map.getOrDefault(last.toString(), "?"));
        }
        return ans.toString();
    }
}
