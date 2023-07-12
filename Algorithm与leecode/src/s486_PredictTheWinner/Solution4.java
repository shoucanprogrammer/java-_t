package s486_PredictTheWinner;

import org.junit.Test;

public class Solution4 {
    @Test
    public void test(){
        PredictTheWinner(new int[]{1,5,233,7});
    }
    public boolean PredictTheWinner(int[] nums) {
       int len = nums.length;
       int[] dp = new int[len];
       for (int i = 0; i < len; i++){
           dp[i] = nums[i];
       }
       for (int i = len - 2; i >=0; i--){
           for (int j = i+1; j < len; j++){
               dp[j] = Math.max(nums[i] - dp[j],nums[j]-dp[j-1]);
           }
       }
        return dp[len-1] >= 0;
    }
}

