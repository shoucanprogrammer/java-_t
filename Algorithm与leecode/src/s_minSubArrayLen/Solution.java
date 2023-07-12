package s_minSubArrayLen;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minSubArrayLen(11,new int[]{1,1,1,1,1,1});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (r<nums.length){
            sum += nums[r];
            if (sum<target){
                r++; //右指针移动
            }else if (sum >= target){
                min = Math.min(min,r-l+1);
                sum -= nums[l];
                sum -= nums[r];
                l++;
            }
        }
        if (min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
