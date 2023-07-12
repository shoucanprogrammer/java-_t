package s260_singleNumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] singleNumber(int[] nums){
        Map<Integer,Integer> freq = new HashMap<Integer,Integer>();
        for (int num : nums){
            freq.put(num,freq.getOrDefault(num,0)+1);
        }
        int[] ans = new int[2];
        int index = 0;
        for (Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if (entry.getValue()==1){
                ans[index++] = entry.getKey();
            }
        }
        return ans;
    }
}
