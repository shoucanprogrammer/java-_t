package s435_eraseOverlapIntervals;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        eraseOverlapIntervals(new int[][]{{1,2},{3,4},{2,3},{1,5}});
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int[] dp = new int[intervals.length];
        Arrays.fill(dp,1);
        for (int r = 1; r < intervals.length ; r++){
            for (int l = 0; l < r; l++){
                if (intervals[l][1] <= intervals[r][0])
                    dp[r] = Math.max(dp[l]+1,dp[r]);
            }
        }


        return intervals.length - Arrays.stream(dp).max().getAsInt();
    }
}
