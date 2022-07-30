package Q0799.Q0714BestTimetoBuyandSellStockwithTransactionFee.solution2;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        int sell = 0, buy = Integer.MIN_VALUE;
        for (int n : prices) {
            buy = Math.max(buy, sell - n);
            sell = Math.max(sell, n - fee + buy);
        }
        return sell;
    }
}