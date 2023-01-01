package Q1799.Q1799MaximizeScoreAfterNOperations.solution;

public class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length, m = 1 << n;
        int[] dp = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = (1 << i) | (1 << j);
                // 计算所选的两数的gcd
                dp[k] = gcd(nums[i], nums[j]);
            }
        }

        // 递推，从前往后
        for (int i = 1; i < m; i++) {
            int cntI = Integer.bitCount(i);
            // 偶数个数字
            if ((cntI & 1) == 1) {
                continue;
            }
            // 枚举 i 的子集
            for (int j = i; j > 0; j = (j - 1) & i) {
                int cntJ = Integer.bitCount(j);
                // 子集的数字个数与i的数字个数差2
                if (cntI - cntJ == 2) {
                    // dp[i ^ j] 为 j的补集，cntI >> 1当作是第k次操作
                    // 由于dp[j]与dp[i ^ j]互补(即后续的dp[j]可能是之前的dp[i ^ j]
                    // (cntI >> 1) 会随着i 一点点的把 (dp[j] or dp[i ^ j]) * (1 ~ k)的所有
                    // 情况全部枚举一次(甚至会重复枚举?)
                    dp[i] = Math.max(dp[i], dp[j] + (cntI >> 1) * dp[i ^ j]);
                }
            }
        }
        return dp[m - 1];
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
