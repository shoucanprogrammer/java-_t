package s1043_maxSumAfterPartitioning;

import org.junit.Test;

public class Solution1{
    @Test
    public void test(){
        maxSumAfterPartitioning(new int[]{1,15,7,9,2,5,10},3);
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        int max = 0;
        for(int i = 0; i <arr.length; i++){
            if (i < k ){
                max = Math.max(max,arr[i]);
                dp[i] = max * (i+1);
            }else {
                max = 0;
                for (int j = i; j > i - k; j--){
                    max = Math.max(max , arr[j]);
                    dp[i] = Math.max(dp[i],dp[j-1] + max * (i-j+1));
                }
            }
        }
        return dp[dp.length-1];
    }
}