package s983_mincostTickets;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    @Test
    public void test(){
        mincostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15});
    }

    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];//最大天数
        int maxLen =maxDay+1;//数组长度
        int[] dp = new int[maxLen];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i < days.length; i++){
            set.add(days[i]);
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
//        int[] time = new int[]{1,7,30};

        for (int i = 1; i  < maxLen; i++){
            if (!set.contains(i)){
                dp[i] = dp[i-1];
            }else {
                int oneDayAgo = i-1;
                int sevenDaysAgo = i-7>0?i-7:0;
                int thirtyDaysAgo = i-30>0?i-30:0;
                dp[i] = Math.min(dp[oneDayAgo]+costs[0],dp[i]);
                dp[i] = Math.min(dp[sevenDaysAgo]+costs[1],dp[i]);
                dp[i] = Math.min(dp[thirtyDaysAgo]+costs[2],dp[i]);
            }
        }
        return dp[maxLen-1];
    }
}
