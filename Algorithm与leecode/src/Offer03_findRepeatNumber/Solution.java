package Offer03_findRepeatNumber;

import java.util.HashSet;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++){
            if (set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return 0;
    }
}
