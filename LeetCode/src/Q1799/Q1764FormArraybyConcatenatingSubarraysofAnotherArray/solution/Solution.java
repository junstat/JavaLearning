package Q1799.Q1764FormArraybyConcatenatingSubarraysofAnotherArray.solution;

public class Solution {
    public boolean canChoose(int[][] gs, int[] nums) {
        int n = nums.length, m = gs.length;
        int cnt = 0;
        for (int i = 0, j = 0; i < n && j < m; ) {
            if (check(gs[j], nums, i)) {
                i += gs[j++].length;
                cnt++;
            } else {
                i++;
            }
        }
        return cnt == m;
    }

    boolean check(int[] g, int[] nums, int i) {
        int j = 0;
        for (; j < g.length && i < nums.length; j++, i++) {
            if (g[j] != nums[i]) return false;
        }
        return j == g.length;
    }
}