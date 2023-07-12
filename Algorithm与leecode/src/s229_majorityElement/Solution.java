package s229_majorityElement;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        majorityElement(new int[]{3,2,3});
    }
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            map.put(num, map.getOrDefault(num,0)+1);
        }
        Set<Integer> set = map.keySet();
        List<Integer> list = new ArrayList<>();
        for (Integer num : set){
           if (map.get(num) > nums.length/3){
               list.add(num);
           }
        }
        return list;
    }
}
