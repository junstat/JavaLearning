package Q0099.Q0072EditDistance;

import java.util.Arrays;

/*
    Note that each time when we update dp[i][j], we only need dp[i-1][j-1], dp[i][j-1] and dp[i-1][j].
    We may optimize the space of the code to use only two vectors.
 */
public class Solution2 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] pre = new int[n + 1];
        int[] cur = new int[n + 1];
        for (int i = 1; i <= n; i++) pre[i] = i;
        for (int i = 1; i <= m; i++) {
            cur[0] = i;
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cur[j] = pre[j - 1];
                else
                    cur[j] = Math.min(pre[j - 1], Math.min(cur[j - 1], pre[j])) + 1;
            }
            // cur -> pre
            System.arraycopy(cur, 0, pre, 0, cur.length);
            Arrays.fill(cur, 0);
        }
        return pre[n];
    }
}
