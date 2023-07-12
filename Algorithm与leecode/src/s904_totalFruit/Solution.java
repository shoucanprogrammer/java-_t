package s904_totalFruit;

import org.junit.Test;

import java.util.*;

public class Solution {
    @Test
    public void test(){
        totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
    }
    public int totalFruit(int[] fruits) {
        int l= 0;
        int r = 0;
        int max = 0;
        Map<Integer,Integer> maps = new HashMap<>();
        while (r<fruits.length){
            if (maps.containsKey(fruits[r])||maps.size()<2){
                maps.put(fruits[r],maps.getOrDefault(fruits[r],0)+1);
            }
            if (!maps.containsKey(fruits[r])&&maps.size()==2){//满了
                int a = maps.get(fruits[r-1]);
                int b = maps.get(fruits[l]);
                max = Math.max(max,r-l);
                maps.put(fruits[l],maps.get(fruits[l])-1);
                if (maps.get(fruits[l])==0){
                    maps.remove(fruits[l]);
                }
                l++;
                r--;
            }
            r++;
        }
        max = Math.max(max,r-l);
        return max;
    }
}
