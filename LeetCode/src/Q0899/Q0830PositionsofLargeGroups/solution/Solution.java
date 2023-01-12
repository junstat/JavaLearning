package Q0899.Q0830PositionsofLargeGroups.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            for (; j < n && cs[j] == cs[i]; j++) ;
            if (j - i >= 3) ans.add(Arrays.asList(i, j - 1));
            i = j;
        }
        return ans;
    }
}
