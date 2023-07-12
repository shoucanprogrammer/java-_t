package Offer10_1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i< n+1;i++){
            dp[i] = (dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
