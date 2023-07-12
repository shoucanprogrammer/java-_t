package s152_maxProduct;

import org.junit.Test;

//public class Solution {
////    @Test
////    public void test(){
////        maxProduct(new int[]{-3,0,1,-2});
////    }
//    public int maxProduct(int[] nums) {
//        int sum = nums[0];
//        int max = Integer.MIN_VALUE;
//        for (int l = 0; l < nums.length -1;l++){
//            sum = nums[l];
//            max = Math.max(sum,max);
//            for (int r = l+1; r < nums.length; r++){
//                sum *= nums[r];
//                max = Math.max(sum,max);
//            }
//
//        }
//        return Math.max(max,nums[nums.length-1]);
//    }
//}
public class Solution {
   @Test
   public void test(){
        maxProduct(new int[]{-3,0,1,-2});
    }
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }
}

