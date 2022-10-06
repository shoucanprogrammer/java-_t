package s48_rotate;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int[][] matrix_new = new int[length ][length ];
        int tem;
        for (int i = 0; i < length; i++){
            for (int j = 0; j < length; ++j){
                matrix_new[j][length - i - 1] = matrix[i][j];
            }
        }
        for (int i = 0; i < length; ++i) {
            for (int j = 0; j < length; ++j) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
