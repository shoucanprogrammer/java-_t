package s322_coinChange;

import org.junit.jupiter.api.Test;

public class Solution1 {
    @Test
    public void test() {
        coinChange(new int[] {2},3);
    }
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount+1]) == Integer.MAX_VALUE ? 0 : coinChange(coins, amount, new int[amount+1]);
    }
    public int coinChange(int[] coins, int rem, int[] mers) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        //遍历
        int min = Integer.MAX_VALUE-1;
        for (int i = 0; i < coins.length; i++) {
            if (rem - coins[i] > -1 && mers[rem - coins[i]] != 0) {
                min = Math.min(min,mers[rem - coins[i]]);
            }else {
                //递归
                if (coinChange(coins,rem - coins[i], mers) == -1){
                    continue;
                }
                min = Math.min(min,coinChange(coins,rem - coins[i], mers));
            }
        }
        mers[rem] = min + 1;
        return mers[rem] ;
    }
}

