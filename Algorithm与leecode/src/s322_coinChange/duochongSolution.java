package s322_coinChange;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class duochongSolution {
   @Test
   public void test() {
       int i = coinChange(new int[]{1, 1, 1, 2, 2, 5}, 11);
       System.out.println(i);
   }
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[][] dp = new int[coins.length ][amount + 1];
        for (int i = 0; i < coins.length ; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE /2);
            dp[i][0] = 0;
        }

        dp[0][0] = 0;
        for (int i = 1; i < coins.length ; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                 if (j >= coins[i] ) {
                    dp[i][j] = Math.min(dp[i ][j], dp[i - 1][j - coins[i]] + 1);
                }

            }
        }
        return dp[coins.length -1][amount] > amount ? -1 : dp[coins.length - 1][amount];
    }

}
