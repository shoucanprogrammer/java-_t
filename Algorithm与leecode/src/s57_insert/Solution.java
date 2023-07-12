package s57_insert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test() {
        int[][] a = {{0,5},{9,12}};
        int[] b = {7,16};
        int[][] merge = insert(a,b);
        System.out.print(0);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> merged = new ArrayList<>();
        //放两端
        //放首端
        int len = intervals.length;
        if (intervals.length == 0){
            merged.add(newInterval);
            return merged.toArray(new int[merged.size()][]);
        }
        if (intervals[0][0] > newInterval[1]){
            merged.add(newInterval);
            for (int i = 0; i < intervals.length; i++){
                merged.add(intervals[i]);
            }
            return merged.toArray(new int[merged.size()][]);
        }
        //放尾端
        if (intervals[intervals.length-1][1] < newInterval[0]){
            for (int i = 0; i < intervals.length; i++){
                merged.add(intervals[i]);
            }
            merged.add(newInterval);
            return merged.toArray(new int[merged.size()][]);
        }
    int r = 0;
    int l = 0;
    int fla = 0;
    for (int i = 0; i < intervals.length; i++){
        fla =0;
        //进入区间
        //从头进入
        if (intervals[0][0] > newInterval[0] ){
            l = newInterval[0];
            //从末尾出
            if (newInterval[1] >= intervals[intervals.length-1][1]){
                r = newInterval[1];
                merged.add(new int[]{l,r});
                return merged.toArray(new int[merged.size()][]);
            }
            for (int j = i ; j < intervals.length; j++ ){

                //中间出
                if (intervals[j][0] <= newInterval[1] && intervals[j][1] >= newInterval[1]){
                    r = intervals[j][1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }
                //从之间出来
                if (intervals[j][1] < newInterval[1] && intervals[j+1][0] > newInterval[1]){
                    r = newInterval[1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }
            }
        }
        //区间中间进
        if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0] ){

            l = intervals[i][0];
            //从末尾出
            if (newInterval[1] >= intervals[intervals.length-1][1]){
                r = newInterval[1];
                merged.add(new int[]{l,r});
                return merged.toArray(new int[merged.size()][]);
            }
            for (int j = i ; j < intervals.length; j++ ){

                //中间出
                if (intervals[j][0] <= newInterval[1] && intervals[j][1] >= newInterval[1]){
                    r = intervals[j][1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }
                //从之间出来
                if (intervals[j][1] < newInterval[1] && intervals[j+1][0] > newInterval[1]){
                    r = newInterval[1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }


            }
            //出
        }
        //之间插入
        if (intervals[i][1] < newInterval[0] && intervals[i+1][0] > newInterval[0]){
            merged.add(intervals[i]);
            l = newInterval[0];
            //从末尾出
            if (newInterval[1] >= intervals[intervals.length-1][1]){
                r = newInterval[1];
                merged.add(new int[]{l,r});
                return merged.toArray(new int[merged.size()][]);
            }
            for (int j = i ; j < intervals.length; j++ ){

                //中间出
                if (intervals[j][0] <= newInterval[1] && intervals[j][1] >= newInterval[1]){
                    r = intervals[j][1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }
                //从之间出来
                if (intervals[j][1] < newInterval[1] && intervals[j+1][0] > newInterval[1]){
                    r = newInterval[1];
                    merged.add(new int[]{l,r});
                    i = j;
                    fla = 1;
                    break;
                }
            }
        }
        if (fla == 0){
            merged.add(intervals[i]);
        }
        }
    return merged.toArray(new int[merged.size()][]);
    }
}
