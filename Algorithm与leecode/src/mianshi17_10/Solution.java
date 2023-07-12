package mianshi17_10;

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length/2;
        if (nums.length == 1){
            return nums[0];
        }
        int conut = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i-1]){
                conut++;
            }else {
                conut = 1;
            }
            if (conut > n){
                return nums[i];
            }
        }
        return -1;
    }
}
