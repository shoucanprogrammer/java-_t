package s134_canCompleteCircuit;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        int i = canCompleteCircuit(new int[]{ 4,5,2,6,5,3}, new int[]{3,2,7,3,2,9});


    }
    public int canCompleteCircuit(int[] gas, int[] cost) {

//        int [][] resLabel = new int[gas.length][2];
//        for (int i = 0; i < gas.length; i++){
//            resLabel[i][0] = gas[i] - cost[i];
//            resLabel[i][1] = i;
//        }
//        Arrays.sort(resLabel,(a,b)->b[0]-a[0]);
//        for (int i = 0; i < gas.length; i++){
//            int solution = solution(resLabel[i][1], gas, cost);
//            if (solution>-1){
//                return solution;
//            }
//        }
        int i = 0;
        while (i<gas.length){
            int solution = solution(i, gas, cost);
            if (solution == gas.length){
                return i;
            }else {
                i = i+solution+1;
            }

        }
        return -1;
    }
    public int solution(int i,int[] gas,int[] cost){
        int k = i;
        int num = 0;
        int gasnow = 0;
        while (num < gas.length){
            gasnow += gas[k] -cost[k];
            if (gasnow < 0){
               return num;
            }
            k++;
            num++;
            if (k==gas.length){
                k = k%gas.length;
            }
        }
//        if (gasnow>=0){
//            return i;
//        }
        return num;
    }
}
