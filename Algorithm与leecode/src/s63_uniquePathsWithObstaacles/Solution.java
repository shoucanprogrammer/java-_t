package s63_uniquePathsWithObstaacles;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}});
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] step = new int[m][n];
        //寻找障碍物坐标
        //并且给step赋初值
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    step[i][j] = 0;
                }else {
                    if ((i==0 && j==0)){
                        step[i][j] =1;
                    }else if(i == 0){
                        step[i][j] = step[i][j-1];

                    }else if (j == 0){
                        step[i][j] = step[i-1][j];
                    }else {
                        step[i][j] = step[i-1][j]+step[i][j-1];
                    }
                }
            }
        }
        return step[m-1][n-1];
    }
}
