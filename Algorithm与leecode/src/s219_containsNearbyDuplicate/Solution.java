package s219_containsNearbyDuplicate;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    @Test
    public void test(){
        containsNearbyDuplicate1(new int[]{1,2,3,1,2,3},2);
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++){
            for (int j = 1; j <= k &&j+i<nums.length; j++){
                if (nums[i] == nums[i+j]){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }


}