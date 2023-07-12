package OfferII008_minSubArrayLen;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        minSubArrayLen(15,new int[]{1,2,3,4,5});
    }
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        pre[0] = 0;
        for (int i = 1; i < n+1; i++){
            pre[i] = pre[i-1] + nums[i-1];
        }
        //遍历长度
        for (int len = 1; len <= n; len++){
            for (int i = 0; i <= n&&i+len<n+1; i++){
                if (pre[i+len] - pre[i] >= target){
                    return len;
                }
            }
        }
        return 0;
    }
}
