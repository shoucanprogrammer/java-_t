package s643_findMaxAverage;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        findMaxAverage(new int[]{-1},1);
    }
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int l = 0;
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < nums.length; r++){
                sum += nums[r];
                if (r-l == k-1){
                max = Math.max(max,sum);
                sum -= nums[l];
                l++;
            }

        }

        return 1.0*max/k;
    }
}
