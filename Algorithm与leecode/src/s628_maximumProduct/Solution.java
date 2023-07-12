package s628_maximumProduct;

import java.util.Arrays;

public class Solution {
    public int maximumProduct(int[] nums){
        int res = 1;
        if (nums.length <= 3){
            for (int i = 0; i < nums.length; i++){
                res *= nums[i];
            }
            return res;
        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[nums.length -1 ] ,nums[nums.length - 1 ] * nums[nums.length - 2] * nums[nums.length - 3] );
    }
}
