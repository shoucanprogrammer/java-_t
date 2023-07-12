package s1184_distanceBetweenBusStops;

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination){
            int cur = start;
            start = destination;
            destination = cur;
        }
        //正向
        int res1 = 0;
        for (int i = start; i < destination; i++){
            res1 += distance[i];
        }
        ///反向
        int res2 = 0;
        for (int i = 0 ; i < start; i ++){
            res2 += distance[i];
        }
        for (int i = destination ; i < distance.length ; i ++){
            res2 += distance[i];
        }
        return Math.min(res1,res2);
    }
}
