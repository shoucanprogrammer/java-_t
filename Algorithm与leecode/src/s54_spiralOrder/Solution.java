package s54_spiralOrder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Boolean[][] matrixfla = new Boolean[row][col];
        for (int i = 0; i< row; i++){
            for (int j =0; j < col; j++){
                matrixfla[i][j] = true;
            }
        }
        List<Integer> list = new ArrayList();
        int row1 = 0;
        int col1 = 0;
        while(true){
            //左
            while (true){
                if(col1<col&&matrixfla[row1][col1]!=false){
                    matrixfla[row1][col1]=false;
                    list.add(matrix[row1][col1]);
                    col1 += 1;
                }else {
                    col1--;
                    row1++;
                    break;
                }
            }
            //下
            while (true){
                if(row1<row&&matrixfla[row1][col1]!=false){
                    matrixfla[row1][col1]=false;
                    list.add(matrix[row1][col1]);
                    row1 += 1;
                }else {
                    row1--;
                    col1--;
                    break;
                }
            }
            //右
            while (true){
                if(col1>-1&&matrixfla[row1][col1]!=false){
                    matrixfla[row1][col1]=false;
                    list.add(matrix[row1][col1]);
                    col1 -= 1;
                }else {
                    col1++;
                    row1--;
                    break;
                }
            }
            //上
            while (true){
                if(row1>-1&&matrixfla[row1][col1]!=false){
                    matrixfla[row1][col1]=false;
                    list.add(matrix[row1][col1]);
                    row1 -= 1;
                }else {
                    row1++;
                    col1++;
                    break;
                }
            }
            //走到尽头
            if (col1>=col||row1>=row||row1<0||row1<0){
                break;
            }
            if (!(col1<col&&matrixfla[row1][col1]!=false)&&!(row1<row&&matrixfla[row1][col1]!=false)||!(col1>-1&&matrixfla[row1][col1]!=false)||
                   !(row1>-1&&matrixfla[row1][col1]!=false)){
                break;
            }
        }
        return list;
    }
}
