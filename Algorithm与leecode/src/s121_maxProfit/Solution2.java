package s121_maxProfit;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int minlast = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i] < minlast){
                minlast = prices[i];
            }
            max = Math.max(prices[i] - minlast,max);
        }
        return max;
    }
}
