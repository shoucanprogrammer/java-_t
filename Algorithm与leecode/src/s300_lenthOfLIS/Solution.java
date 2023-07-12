package s300_lenthOfLIS;

public class Solution {
    public int lenthOfLIS(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int r = 1; r < nums.length; r++){
            dp[r] = 1;
            for (int l = 0; l < r; l ++){
                if (nums[r] > nums[l]){
                    dp[r] = Math.max(dp[l]+1,dp[r]);
                }
            }
            maxans = Math.max(maxans, dp[r]);
        }


        return maxans;
    }
}
