package LCR013_NumMatrix;

import org.junit.jupiter.api.Test;
class Solution{
    NumMatrix numMatrix;
    @Test
    public void test(){
        numMatrix = new NumMatrix(new int[][]{{-4,-5}});
        numMatrix.sumRegion(0,1,0,1);
    }
}
class NumMatrix {

    int[][] sums;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++ ) {
                for (int j = 0; j < n; j++) {
                   if (j > 0){
                       sums[i][j] = sums[i][j - 1] + matrix[i][j];
                   }else {
                       sums[i][j] = matrix[i][j];
                   }
                }
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = 0;
       for (int i = row1; i <= row2; i++) {
           if (col1  == 0 && col1 != col2){
               result += (sums[i][col2]);
           }else if (col1 != col2){
               result += (sums[i][col2] - sums[i][col1 - 1]);
           }else if (col1 == col2 && col1  == 0){
               result += sums[i][col2];
           }else if (col1 == col2 && col1  != 0){
               result  += sums[i][col1] - sums[i][col1 - 1];
           }

       }
       return result;
    }
}
