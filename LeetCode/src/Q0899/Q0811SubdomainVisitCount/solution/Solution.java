package Q0899.Q0811SubdomainVisitCount.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> count = new HashMap<>();
        for (String cd : cpdomains) {
            int i = cd.indexOf(' ');
            int n = Integer.parseInt(cd.substring(0, i));
            String s = cd.substring(i + 1);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    String d = s.substring(j + 1);
                    count.put(d, count.getOrDefault(d, 0) + n);
                }
            }
            count.put(s, count.getOrDefault(s, 0) + n);
        }

        List<String> ans = new ArrayList<>();
        for (String d : count.keySet()) ans.add(count.get(d) + " " + d);
        return ans;
    }
}
