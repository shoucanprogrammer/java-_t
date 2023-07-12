package s1695.maximumUniqueSubarray;

import org.junit.Test;

import java.util.HashMap;

public class Solution {
    @Test
    public void test(){
        maximumUniqueSubarray(new int[]{4,2,4,5,6});
    }
    public int maximumUniqueSubarray(int[] nums){
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        while (r < nums.length){
            if (map.containsKey(nums[r])){
                Integer label = map.get(nums[r]);

                for (int i = l; i < label ; i++){
                    sum -= nums[i];
                    map.remove(nums[i]);
                }
                l = label + 1;
                map.put(nums[r],r);
                r++;
            }else {
                map.put(nums[r],r);
                sum += nums[r];
                ans = Math.max(ans,sum);
                r++;
            }
        }
        return ans;
    }
}
