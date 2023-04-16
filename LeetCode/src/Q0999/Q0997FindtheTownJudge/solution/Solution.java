package Q0999.Q0997FindtheTownJudge.solution;

public class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in = new int[n + 1], out = new int[n + 1];
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            in[b]++;
            out[a]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }
}