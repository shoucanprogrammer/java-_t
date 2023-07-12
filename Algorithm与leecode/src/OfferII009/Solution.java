package OfferII009;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        numSubarrayProductLessThanK(new int[]{1,2,3},0);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        int j = 0;
        int k1 = 1;
        for (int i = 0; i < nums.length; i++){
            for ( ; j < nums.length; j++){
                k1 *= nums[j];
                if (k1 < k){
                }else {
                    break;
                }
            }
            if (j < i){
                j = i;
                continue;
            }
            ans += j - i ;
            k1 = k1 / nums[i];
            if (j < nums.length){
                k1 = k1 / nums[j];
            }

        }
        return ans;
    }
}