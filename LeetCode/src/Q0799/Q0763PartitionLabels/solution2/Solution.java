package Q0799.Q0763PartitionLabels.solution2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Solution 2: Extending Boundary
public class Solution {
    public List<Integer> partitionLabels(String ss) {
        int n = ss.length();
        int[] last = new int[26];
        char[] s = ss.toCharArray();
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) last[s[i] - 'a'] = i;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int start = i;
            for (int end = i + 1; i < end; i++) end = Math.max(end, last[s[i] - 'a'] + 1);
            ans.add(i - start);
        }
        return ans;
    }
}
