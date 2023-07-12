package s322_coinChange;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        coinChange(new int[]{2},11);
    }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 0; i < coins.length;i++){
            for (int j = 1; j < max; j++){
                if (j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }

        }
        if( dp[amount]>amount){
                return -1;
        }
        return dp[amount];
    }
}