package s813_largestSumOfAverages;

import java.util.Arrays;

public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        double sum1 = 0;
        for (int i = n - 1; i > n - k ; i--){
            sum1 += nums[i];
        }
        double sum2 = 0;
        for (int i = n - k; i >= 0; i--){
            sum2 += nums[i];
        }
        return sum1 + sum2/(n-k+1);
    }
}
