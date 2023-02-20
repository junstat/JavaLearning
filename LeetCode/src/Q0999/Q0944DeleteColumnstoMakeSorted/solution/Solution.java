package Q0999.Q0944DeleteColumnstoMakeSorted.solution;

public class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length(), ans = 0;
        out:
        for (int i = 0; i < m; i++) {
            for (int j = 0, cur = -1; j < n; j++) {
                int t = (int) strs[j].charAt(i);
                if (t < cur && ++ans >= 0) continue out;
                cur = t;
            }
        }
        return ans;
    }
}