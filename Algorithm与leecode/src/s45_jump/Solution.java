package s45_jump;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
    public int jump(int[] nums) {
        int start = 0;
        int len = nums.length;
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < len -1 ; i++){
            maxPosition = Math.max(maxPosition,i+nums[i]);
            if (i == end){
                end = maxPosition;;
                step++ ;
            }
        }
        return  step;
    }




    public int jump1(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }



}
