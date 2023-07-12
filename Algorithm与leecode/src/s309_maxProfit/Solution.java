package s309_maxProfit;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        maxProfit(new int[]{1,2,3,0,2});
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];//抛售点
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);//冷冻期
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}

