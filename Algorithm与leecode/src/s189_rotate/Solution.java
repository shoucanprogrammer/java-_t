package s189_rotate;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }
    public void rotate(int[] nums, int k){
        int len = nums.length;
        if (k == 0){
            return;
        }
        for (int i = k; i > 0; i--){
            int cur = nums[len -1];
            for (int j = len-2; j>= 0; j --){
                nums[j + 1] = nums[j];
            }
            nums[0] = cur;
        }


    }
}
