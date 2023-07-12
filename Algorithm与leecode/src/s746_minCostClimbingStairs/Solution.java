package s746_minCostClimbingStairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[][] dp = new int[cost.length][2];
        dp[0][0] = cost[0];
        dp[0][1] = 0;
        dp[1][0] = cost[1];
        dp[1][1] = dp[0][0];
        for (int i = 2; i < cost.length; i++){
            dp[i][0] = Math.min(dp[i-1][0],dp[i-2][0])+cost[i];
            dp[i][1] = dp[i-1][0];
        }

        return Math.min(dp[cost.length-1][0],dp[cost.length-1][1]);
    }
}
