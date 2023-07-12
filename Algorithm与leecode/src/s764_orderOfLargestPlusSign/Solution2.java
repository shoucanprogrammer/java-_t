package s764_orderOfLargestPlusSign;

import org.junit.Test;

public class Solution2 {
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
        int[][][] dp = new int[n][n][4];  //上下左右
        //遍历
        int ans = 0;
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n - 1; j++){   // 右遍历
                if (matrix[i][j] == 0){
                    if ( j == 0){
                        dp[i][j][3] = 1;
                    }else {
                        dp[i][j][3] = dp[i][j-1][3]+1;
                    }
                }else {
                    dp[i][j][3] = 0;
                }
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = n - 1; j >=  0; j--){   // 左遍历
                if (matrix[i][j] == 0){
                    if ( j == n-1){
                        dp[i][j][2] = 1;
                    }else {
                        dp[i][j][2] = dp[i][j+1][2]+1;
                    }
                }else {
                    dp[i][j][2] = 0;
                }
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = n - 1; j >=  0; j--){   //上
                if (matrix[j][i] == 0){
                    if ( j == n-1){
                        dp[j][i][0] = 1;
                    }else {
                        dp[j][i][0] = dp[j+1][i][0]+1;
                    }
                }else {
                    dp[i][j][0] = 0;
                }
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n - 1; j++){   // 下
                if (matrix[j][i] == 0){
                    if ( j == 0){
                        dp[j][i][1] = 1;
                    }else {
                        dp[j][i][1] = dp[j-1][i][1]+1;
                    }
                }else {
                    dp[j][i][1] = 0;
                }
            }
        }
        for (int i = 0; i <= n - 1; i++){
            for (int j = 0; j <= n - 1; j++){   // 右遍历
                int min = Integer.MAX_VALUE;
               min = Math.min(dp[i][j][0],dp[i][j][1]);
               min = Math.min(min,dp[i][j][2]);
               min = Math.min(min,dp[i][j][3]);
               ans = Math.max(min,ans);
            }
        }


        return ans ;
    }

}
