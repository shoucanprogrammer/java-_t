package s217_containsDuplicate;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
