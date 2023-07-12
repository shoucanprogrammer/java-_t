package s764_orderOfLargestPlusSign;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 执行用时：22 ms, 在所有 Java 提交中击败了98.32%的用户
 内存消耗：43.5 MB, 在所有 Java 提交中击败了90.50%的用户
 通过测试用例：56 / 56
 */
class Solution1 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int grid[][] = new int[n][n];
        for(int[] item: mines)grid[item[0]][item[1]] = 1;// 生成矩阵grid。注意这里的0和1是反的，这并不会影响结果，判断的时候反过来即可。

        int dp[][] = new int[n][n];
        int ret = 0; //len表示某个方向上的臂长
        for(int x = 0; x < n; x++){// x表示中心点的横坐标
            /** (x, y)点的上臂*/
            for(int y = 0, len = 0; y < n; y++){ //y表示中心点的纵坐标；len表示臂长
                len = grid[x][y] == 1 ? 0 : ++len;
                dp[x][y] = len;
            }
            /** (x, y)点的下臂*/
            for(int y = n - 1, len = 0; y >= 0; y--){
                len = grid[x][y] == 1 ? 0 : ++len;
                dp[x][y] = Math.min(dp[x][y], len);
            }
        }
        for(int y = 0; y < n; y++){
            /** (x, y)点的左臂*/
            for(int x = 0, len = 0; x < n; x++){
                len = grid[x][y] == 1 ? 0 : ++len;
                dp[x][y] = Math.min(dp[x][y], len);
            }
            /** (x, y)点的右臂*/
            for(int x = n - 1, len = 0; x >= 0; x--){
                len = grid[x][y] == 1 ? 0 : ++len;
                dp[x][y] = Math.min(dp[x][y], len);
                // System.out.printf("%s %s %s %s\n", x, y, dp[x][y], grid[x][y]);
                ret = Math.max(dp[x][y], ret);
            }
        }
        return ret;
    }
}