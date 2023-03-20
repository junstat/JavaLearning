package Q2399.Q2379MinimumRecolorstoGetKConsecutiveBlackBlocks.solution;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        char[] s = blocks.toCharArray();
        int cnt = 0;
        for (int i = 0; i < k; i++) if (s[i] == 'W') cnt++;
        int ans = cnt;
        for (int i = 1; i + k - 1 < n; i++) {
            if (s[i - 1] == 'W') cnt--;
            if (s[i + k - 1] == 'W') cnt++;
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}
