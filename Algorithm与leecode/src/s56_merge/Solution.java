package s56_merge;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    @Test
    public void test() {
        int[][] a = {{1, 4}, {4, 5},{7,8}};
        int[][] merge = merge(a);
        System.out.print(0);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        int[][] cur = new int[1][2];
//        for (int i = 0; i < intervals.length; i++) {
//            for (int j = i + 1; j < intervals.length; j++) {
//                if (intervals[i][0] > intervals[j][0]) {
//                    cur[0][0] = intervals[i][0];
//                    cur[0][1] = intervals[i][1];
//                    intervals[i][0] = intervals[j][0];
//                    intervals[i][1] = intervals[j][1];
//                    intervals[j][0] = cur[0][0];
//                    intervals[j][1] = cur[0][1];
//                }
//            }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
//        }
        List<int[]> merged = new ArrayList<>();
        int a = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];
            for (int j = i + 1; j < intervals.length; j++) {

                if (r >= intervals[j][0]) {
                    if (r >= intervals[j][1]) {
                        r = r;
                        i = i + 1;
                        j = i;

                    } else {
                        r = intervals[j][1];
                        i = i + 1;
                        j = i;
                    }

                }
            }
            merged.add(new int[]{l, r});
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
