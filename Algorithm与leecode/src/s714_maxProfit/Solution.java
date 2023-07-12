package s714_maxProfit;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        maxProfit(new int[]{1, 3, 2, 8, 4, 9},2);
    }
    public int maxProfit(int[] prices, int fee){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][1] - prices[i], dp[i-1][0]);   //持有股票
            dp[i][1] = Math.max(dp[i-1][0] + prices[i] - fee, dp[i-1][1]);  //不持有股票
        }
        return dp[prices.length-1][1];
    }
}
