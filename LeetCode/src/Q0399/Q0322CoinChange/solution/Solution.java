package Q0399.Q0322CoinChange.solution;

import java.util.Arrays;

/*
    01背包问题
    dp[v] = max(dp[v], dp[v - w[i]] + c[i])

    算法分析: https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 */
public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
