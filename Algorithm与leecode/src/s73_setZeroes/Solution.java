package s73_setZeroes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        setZeroes1(new int[][]{{1,1,1},{1,0,1},{1,0,1}});
    }
    public void setZeroes(int[][] matrix){
        if (matrix == null){
            return ;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //记录0的坐标
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == 0){
                    list.add(new int[]{i,j});
                }
            }
        }
        //修改矩阵
        for (int[] label:list){
            int x = label[0];
            int y = label[1];
            //x
            for (int i = 0; i < n; i++){
                matrix[x][i] = 0;
            }
            for (int i = 0; i < m; i++){
                matrix[i][y] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagCol0 = false, flagRow0 = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagCol0 = true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                flagRow0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }


}
