package Q0199.Q0121BestTimetoBuyandSellStock;

public class Solution3 {
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
