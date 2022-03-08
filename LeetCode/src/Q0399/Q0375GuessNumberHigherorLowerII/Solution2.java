package Q0399.Q0375GuessNumberHigherorLowerII;

// Runtime: 7 ms, faster than 96.02% of Java online submissions for Guess Number Higher or Lower II.
public class Solution2 {
    public int getMoneyAmount(int n) {
        return this.recursive(new int[n + 1][n + 1], 1, n);
    }

    private int recursive(int[][] dp, int low, int high) {
        if (low >= high) {
            return 0;
        } else if (dp[low][high] > 0) {
            return dp[low][high];
        } else {
            dp[low][high] = Integer.MAX_VALUE;
            int mid = (low + high) / 2;
            for (int idx = mid; idx < high; idx++) {
                int left = this.recursive(dp, low, idx - 1);
                int right = this.recursive(dp, idx + 1, high);
                dp[low][high] = Math.min(dp[low][high], idx + Math.max(left, right));
                if (left >= right) {
                    break;
                }
            }
        }
        return dp[low][high];
    }
}
