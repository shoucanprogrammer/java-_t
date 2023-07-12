package mianshi16_17;

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++){
            if (dp[i-1] < 0){
                dp[i] = nums[i];
            }else {
                dp[i] = dp[i-1] + nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}
