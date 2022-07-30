package Q0799.Q0714BestTimetoBuyandSellStockwithTransactionFee.solution1;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int n = prices.length, buy = Integer.MIN_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            buy = Math.max(buy, dp[i] - prices[i]);
            dp[i + 1] = Math.max(dp[i], prices[i] - fee + buy);
        }
        return dp[n];
    }
}