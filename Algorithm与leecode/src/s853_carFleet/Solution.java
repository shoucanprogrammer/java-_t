package s853_carFleet;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    @Test
    public void test(){
        carFleet(31,new int[]{5,26,18,25,29,21,22,12,19,6},new int[]{7,6,6,4,3,4,9,7,6,4});
    }
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] ps= new double[position.length][2];
        for (int i = 0; i < position.length;i++){
            ps[i][0] = position[i];
            ps[i][1] = speed[i];
        }
        Arrays.sort(ps, (a,b)-> (int) (b[0] - a[0]));
        int ans = 0;
        int j = 0;
        double beishu;
        while (j < position.length){  //达到的车数
            beishu = (1.0*target - ps[j][0])/ps[j][1];
            for (int i = j; i < position.length; i++){
                ps[i][0] +=  beishu* ps[i][1];
            }
            ans++;
            for (int i = j; i < position.length&&ps[i][0]>=target; i++){
                j = i+1;
            }
        }
        return ans;
    }
}
