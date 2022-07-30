package Q0799.Q0714BestTimetoBuyandSellStockwithTransactionFee.solution3;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        long sell = 0, buy = Integer.MIN_VALUE;
        for (int n : prices) {
            long buy2 = Math.max(buy, sell - n);
            long sell2 = Math.max(sell, buy + n - fee);
            buy = buy2;
            sell = sell2;
        }
        return (int) sell;
    }
}