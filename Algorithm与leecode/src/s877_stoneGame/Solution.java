package s877_stoneGame;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        stoneGame(new int[]{5,3,4,5});
    }
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++){
            dp[i] = piles[i];
        }
        for (int i = len -2; i >= 0; i--){
            for (int j = i+1; j < len; j++){
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j -1]);
            }
        }
        return dp[len-1] > 0;
    }
}
