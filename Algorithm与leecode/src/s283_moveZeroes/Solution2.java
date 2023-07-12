package s283_moveZeroes;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    @Test
    public void test(){
        checkSubarraySum(new int[]{0,0},1);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2){
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0 ; i < n; i++){
            sum += nums[i];
            int rem = sum % k;
            if (!map.containsKey(rem)){
                if (rem == 0 && i >= 1){
                    return true;
                }
                map.put(rem,i);
            }else {
                if (map.get(rem) < i - 1){
                    return true;
                }
                if (rem == 0){
                    return true;
                }
            }


        }
        return false;
    }
}