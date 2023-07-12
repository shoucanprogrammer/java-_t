package s377_combinationSum4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        float a = 2.0f;
        double b = 2;
        long d= 2;
        combinationSum4(new int[]{1,2,3},4);
        List<int[]> list = new ArrayList<>();
        Integer integer = Integer.valueOf("1");
        String s = "1";
        String s2 = integer.toString();
        int i = Integer.parseInt(s);
    }
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < len; j++){
                if (nums[j] <= i){
                    dp[i] = dp[i - nums[j]] + dp[i];
                }
            }
        }
        return dp[target];
    }
}
