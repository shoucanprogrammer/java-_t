package s396_maxRotateFunction;

import java.util.Map;

public class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int sum = 0;
            for ( int j = 0; j < nums.length; j++){
                sum += nums[j] * ((i + j )% nums.length);
            }
            max = Math.max(sum,max);
        }
        return max;
    }
}
