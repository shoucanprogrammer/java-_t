package s740_deleteAndEarn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    @Test
    public void test(){
        deleteAndEarn(new int[]{3,3,3});
    }
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
//        int first = nums[0], second = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i < size; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[size-1];
    }
}