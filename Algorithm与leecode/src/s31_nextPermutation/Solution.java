package s31_nextPermutation;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        nextPermutation(new int[]{1,3,2});
    }
    public void nextPermutation(int[] nums){
        int len = nums.length;
        int tem ;
        int r;
        int l = 0;
        int m = 0;
        boolean flaswap = false;
        for (r = len -1 ; r >=0 ; r--){
            for (l = r-1; l >=0; l--){
                for (m = r; m > l ;m--){
                    //如果前面的值小于后面的
                    //交换两个值
                    if (nums[m] > nums[l]){
                        tem = nums[m];
                        nums[m] = nums[l];
                        nums[l] = tem;
                        //标志位更改
                        flaswap = true;
                        break;
                    }
                }
                if (flaswap){
                    break;
                }
            }
            if (flaswap){
                break;
            }
        }
        if (flaswap){
            Arrays.sort(nums,l+1,len);
        }else {
            int[] nums1 = new int[len];
            for (int i = 0,j = len-1-i; i < len; i++,j--){
                nums1[j] = nums[i];
            }
            for (int i = 0; i < len; i++){
                nums[i] = nums1[i];
            }
        }
    }
}
