package Q0299.Q0279PerfectSquares;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    Solution1 优化
 */
public class Solution2 {
    @Test
    public void test1() {
        assertEquals(3, numSquares(12));
    }

    public int numSquares(int n) {
        if (n < 0) return 0;
        int[] dp = new int[n + 1];
        int lenDp = 1;
        while (lenDp <= n) {
            int cur = Integer.MAX_VALUE;
            for (int i = 1; i * i <= lenDp; i++) {
                cur = Math.min(cur, dp[lenDp - i * i] + 1);
            }
            dp[lenDp++] = cur;
        }
        return dp[lenDp - 1];
    }
}
