package s1043_maxSumAfterPartitioning;

public class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i = 1; i<k ;i ++){
            dp[i] = arr[i] > dp[i-1]/i ? arr[i] * (i+1) : dp[i-1]/i*(i+1);
        }
        for(int i = k; i<arr.length; i++){
            int max = arr[i];
            for(int j = i;  j>i-k; j--){
                max = Math.max(max,arr[j]);
                dp[i] = Math.max(dp[i],dp[j-1]+max*(i-j+1));
            }
        }
        return dp[arr.length-1];
    }
}
