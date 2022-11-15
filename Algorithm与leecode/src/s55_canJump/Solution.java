package s55_canJump;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        canJump(new int[]{3,2,2,0,1,4});;
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i <= maxPosition&& i < length-1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
        }
        if (maxPosition<length-1){
            return false;
        }else {
            return true;
        }
    }
}
