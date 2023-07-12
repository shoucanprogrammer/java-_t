package s1094_carPooling;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        carPooling(new int[][]{{2,1,5},{3,3,7}},4);
    }
    /**
     * 差分数组思路。
     * 计算旅行路上每个位置的上的乘客数量不能超过capacity，否则说明无法把所有乘客运到目的地；
     * 可以使用差分数组来计算每个位置上的乘客数量，然后计算是否超过
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int n = 0;
        for (int[] trip : trips){
            n = Math.max(n,trip[2]);
        }
        int[] diff = new int[n + 1];
        for (int[] trip : trips){
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        // 计算每个位置上的乘客数量，如果超过则直接返回false
        int currCapacity = 0;
        for (int i = 0; i < n; i++) {
            currCapacity += diff[i];
            if (currCapacity > capacity) {
                return false;
            }
        }
        return true;
    }
}
