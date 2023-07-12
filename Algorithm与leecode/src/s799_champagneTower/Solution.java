package s799_champagneTower;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        champagneTower(100000009,33,17);
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = {poured};
        for (int i = 1; i <= query_row; i++){
            double[] nextRow = new double[i+1];
            for (int j = 0; j < i; j++){
                if (row[j] > 1){
                    nextRow[j] += (row[j]-1)/2;
                    nextRow[j+1] += (row[j]-1)/2;
                }
            }
            row = nextRow;
        }
        return Math.min(1,row[query_glass]);
    }
}

