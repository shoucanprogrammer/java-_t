package s64_minPathSum;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] step = new int[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (i==0&&j==0){
                    step[i][j] = grid[i][j];
                }else if (i== 0){
                    step[i][j] = step[i][j-1]+grid[i][j];
                }else if(j == 0){
                    step[i][j] = step[i-1][j] + grid[i][j];
                }else {
                    if (step[i-1][j] >= step[i][j-1]){
                        step[i][j]= step[i][j-1] + grid[i][j];
                    }else {
                        step[i][j] = step[i-1][j] + grid[i][j];
                    }

                }
            }
        }
        return step[m-1][n-1];
    }
}
