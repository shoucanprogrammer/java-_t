package s350_intersect;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        intersect(new int[]{1,2,2,1},new int[]{2,2});
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1){
            map.put(num1,map.getOrDefault(num1,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num2 : nums2){
            if (map.containsKey(num2)){
                list.add(num2);
                int k = map.get(num2);
                if ( k == 1){
                    map.remove(num2);
                }else {
                    map.put(num2,k-1);
                }
            }
        }
        int[] res = new int[list.size()];
        int j = 0;
        for (int i : list){
            res[j] = i;
            j++;
        }
        return res;
    }
}
