package s122_maxProfit;

public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = prices.length-1; i>0; i--){
            if (prices[i] > prices[i-1]){
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
