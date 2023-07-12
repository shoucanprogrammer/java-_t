package s495_findPoisonedDuration;

import java.util.Arrays;

public class Solution {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int length = timeSeries.length;
        int ans = 0;
        int expired = 0;
        for (int i = 0; i < length; i++){
            if (timeSeries[i] >= expired){
                ans += duration;
                expired = timeSeries[i]+duration;
            }else {
                ans += timeSeries[i] + duration - expired;
                expired = timeSeries[i]+duration;
            }
        }
        return ans;
    }
}
