package s2054_maxTwoEvents;

import java.util.Arrays;

public class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        int n = events.length;
        int ans = 0;
        for (int i = 0; i < n ; i++){
            ans = Math.max(ans,events[i][2]);
            for (int j = i+1; j < n; j++){
                if (events[i][1] < events[j][0]){
                    ans = Math.max(events[i][2] + events[j][2],ans);
                }
            }
        }
        return ans;
    }
}
