package s1052_maxSatisfied;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        maxSatisfied(new int[]{1,0,1,2,1,1,7,5},new int[]{0,1,0,1,0,1,0,1},3);
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        //滑动窗口滑动生气
        for (int i = 0; i <customers.length; i++){     //没有技能的满意度

            if (grumpy[i] == 0){
                sum += customers[i];
            }
        }
        int increase = 0;
        for (int i = 0; i < minutes; i++){
            increase += customers[i]*grumpy[i];
        }
        int maxIncrease = increase;

        for (int i = minutes; i < customers.length; i++){
            increase =  increase + grumpy[i]*customers[i] - grumpy[i-minutes]*customers[i-minutes];
            maxIncrease = Math.max(maxIncrease,increase);
        }
        return sum+maxIncrease;
    }
}
