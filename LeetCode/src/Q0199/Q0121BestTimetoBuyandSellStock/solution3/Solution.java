package Q0199.Q0121BestTimetoBuyandSellStock.solution3;

public class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
