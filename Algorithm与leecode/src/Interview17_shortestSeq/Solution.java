package Interview17_shortestSeq;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        shortestSeq(new int[]{526, 558, 125, 101, 573, 69, 28, 109, 307, 641, 496, 889, 476, 256
                , 301, 803, 680, 626, 254, 801, 270, 851, 229, 587, 674, 982, 203, 255, 305, 253, 50, 946,
                575, 510, 189, 247, 117, 712, 283, 741, 389, 783, 1, 749, 288, 574, 945, 102, 822,
                161, 682, 446, 987, 233, 497, 400, 775, 556, 914, 49, 537, 313, 506, 120, 161, 171,
                959, 788, 342, 519, 201, 31, 236, 196, 801, 504, 295, 726, 690, 479, 649,
                655, 963, 548, 834, 572, 974, 118, 221, 919, 39, 364, 30, 199, 888, 89, 229, 149, 109, 720},new int[]{389, 803, 945
                , 295, 946, 479, 149, 283, 851, 89, 496, 497, 537, 256, 31, 342, 313, 626, 446,
                801, 221, 109, 120, 504, 255, 914, 788, 720, 49, 726, 161, 69, 572, 236, 199, 575, 822, 712, 201, 558, 101, 649});
    }
    public int[] shortestSeq(int[] big, int[] small) {
        if (big.length < small.length){
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer num : small){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        HashMap<Integer, Integer> newMap = new HashMap<>();
        int l = 0;
        int r = 0;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (r < big.length ){
            if (!(map.size() == newMap.size())){
                if (map.containsKey(big[r])){
                    newMap.put(big[r],newMap.getOrDefault(big[r],0)+1);
                }
                r++;

            }else {
                if (r - l + 1 < min){
                    min = r - l + 1;
                    ans[0] = l;
                    ans[1] = r -1;
                }
                if (newMap.containsKey(big[l])){
                    if (newMap.get(big[l]) == 1){
                        newMap.remove(big[l]);
                    }else {
                        newMap.put(big[l], newMap.get(big[l])-1);
                    }
                }

                l++;
            }

        }
        while (map.size() == newMap.size()){
            if (r - l + 1 < min){
                ans[0] = l;
                ans[1] = r -1;
            }
            if (newMap.containsKey(big[l])){
                if (newMap.get(big[l]) == 1){
                    newMap.remove(big[l]);
                }else {
                    newMap.put(big[l], newMap.get(big[l])-1);
                }
            }
            l++;
        }

        if (Arrays.equals(ans,new int[]{0,0})){
            return new int[]{};
        }else {
            return ans;
        }
    }
}
