package s764_orderOfLargestPlusSign;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        orderOfLargestPlusSign(5, new int[][]{{4,2}});
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        //构造
        int[][] matrix = new int[n][n];
        for (int[] mine : mines){
            matrix[mine[0]][mine[1]] = 1;
        }

        //遍历
        int ans = 0;
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n - 1; j++){
                if (matrix[i][j] == 0){
                    ans = Math.max(ans,find(i,j,matrix) ) ;
                }
            }
        }
        return ans ;
    }
    public int find(int i,int j,int[][] matrix){
        int count = 1;
        int left = j ,right = j;
        int up = i,down = i;
        while (true){
            //左遍历
            if (--left >= 0 && matrix[i][left] == 0){
            }else {break;}
            //右遍历
            if (++right <= matrix.length -1 && matrix[i][right] == 0){
            }else {break;}
            //上遍历
            if (--up >= 0 && matrix[up][j] == 0){
            }else {break;}
            //下遍历
            if (++down <= matrix.length -1 && matrix[down][j] == 0){
            }else {break;}
            count++;
        }
        return count;
    }
}
