package Q0499.Q0433MinimumGeneticMutation;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Genetic Mutation.
public class Solution2 {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end))
            return 0;
        Set<String> valid = new HashSet<>();
        for (String gene : bank)
            valid.add(gene);

        Set<String> seen = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();
        q.offer(start);
        seen.add(start);

        int steps = 0;
        char[] choices = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            int sz = q.size();
            while (sz-- > 0) {
                String cur = q.poll();
                if (cur.equals(end)) return steps;
                char[] ss = cur.toCharArray();
                for (int i = 0; i < 8; ++i) {
                    char c = ss[i];
                    for (int j = 0; j < 4; ++j) {
                        if (ss[i] == choices[j]) continue;
                        ss[i] = choices[j];
                        String next = new String(ss);
                        if (!valid.contains(next)) continue;
                        if (seen.contains(next)) continue;
                        q.offer(next);
                        seen.add(next);
                    }
                    ss[i] = c;
                }
            }
            steps++;
        }
        return -1;
    }
}
