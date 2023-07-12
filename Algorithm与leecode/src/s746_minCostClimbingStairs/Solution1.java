package s746_minCostClimbingStairs;

public class Solution1 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 0;
        for ( int i = 0; i <= n; i++){
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[n];
    }
}
