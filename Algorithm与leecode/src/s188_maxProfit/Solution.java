package s188_maxProfit;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        maxProfit(2,new int[]{3,2,6,5,0,3});
    }
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i-1][j],sell[i-1][j] - prices[i]);  //sell慢一个循环
                sell[i][j] = Math.max(sell[i-1][j],buy[i-1][j-1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}

