package s62_uniquePaths;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        int i = uniquePaths(3, 7);
        System.out.print(1);
    }
    public int uniquePaths(int m, int n){
        int[][] mat = new int[m][n];
        //边界赋值
        for (int i = 0; i < m; i++){
            mat[i][0] = 1;
        }
        for (int j = 0; j < n; j++){
            mat[0][j] = 1;
        }
        //填值按照行
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[m-1][n-1];
    }
}
