package s1248_numberOfSubarrays;

import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    @Test
    public void test(){
        numberOfSubarrays(new int[]{2,2,2,1,1,2,2,2},2);
    }
    public int numberOfSubarrays(int[] nums, int k) {
        if (nums==null){
            return 0;
        }
        int n = nums.length;

        int l = 0;
        int num = 0;
        for (l = 0; l < n ; l++){

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(Integer.MAX_VALUE,Integer.MIN_VALUE);
            int label = Integer.MAX_VALUE;
            for (int r = l; r < n; r++){
                if (nums[r] % 2 ==1)
                    map.put(nums[r],map.getOrDefault(nums[r],0)+1);

                int max = 0;


                if (max ==k){
                    num++;

                }else if (max >k){
                    map.put(nums[r],map.get(nums[r]) - 1);
                    break;
                }


            }
            if (nums[l] % 2 ==1)
                map.put(nums[l],map.get(nums[l]) - 1);
        }


        return num;
    }
}
