package s436_findRightInterval;

import java.util.Arrays;

public class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] newArr = new int[n][2];
        for (int i = 0; i < n; i++){
            newArr[i][0] = intervals[i][0];
            newArr[i][1] = i;
        }
        Arrays.sort(newArr,(a,b)->a[0]-b[0]);
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            int j = i+1;
            while (j < n && intervals[newArr[i][1]][1] > newArr[j][0]){
                j++;
            }
            if (j < n){
                res[newArr[i][1]] = newArr[j][1];
            }else {
                res[newArr[i][1]] = -1;
            }
        }
        return res;
    }
}
