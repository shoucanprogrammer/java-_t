package OfferII099;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] sum = new int[m][n];
        sum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++){
            sum[0][i] = sum[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1])+grid[i][j];
            }
        }
       return (sum[m-1][n-1]);
    }
}
