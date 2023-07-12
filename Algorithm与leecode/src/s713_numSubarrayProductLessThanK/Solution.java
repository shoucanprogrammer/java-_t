package s713_numSubarrayProductLessThanK;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        numSubarrayProductLessThanK(new int[]{10,9,10,4,3,8,3,3,6,2,10,10,9,3},19);
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        Arrays.sort(nums);

        int cheng = 1;
        int num = 0;
        for (int i = 0; i < nums.length ; i++){
            if (nums[i]<k){
                num++;
            }
        }
        for (int len = 2; len <= nums.length; len++){//子集长度
            for (int l = 0; l< nums.length; l++){
                int r = l+1;
                cheng = nums[l];
                while (r-l<len && r< nums.length){
                    cheng = cheng*nums[r];
                    if (cheng < k && r-l==len-1){
                        num++;
                    }
                    r++;

                }
            }


        }
        return num;
    }
}
