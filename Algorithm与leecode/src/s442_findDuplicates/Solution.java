package s442_findDuplicates;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        findDuplicates (new int[]{4,3,2,7,8,2,3,1});
    }
    public List<Integer> findDuplicates(int[] nums){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           nums[Math.abs(nums[i]) -1] *= -1;
           if (nums[Math.abs(nums[i]) - 1] > 0){
               list.add(Math.abs(nums[i]));
           }
        }
        return list;
    }
}
