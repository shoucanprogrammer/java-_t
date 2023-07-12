package s123__maxProfit;

public class Solution {
    public int maxProfit(int[] prices) {
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < prices.length; i++){
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(prices[i] + buy1,sell1);
            buy2 = Math.max(sell1 - prices[i],buy2);
            sell2 = Math.max(sell2,prices[i] + buy2);
        }
        return Math.max(sell1,sell2);
    }
}
