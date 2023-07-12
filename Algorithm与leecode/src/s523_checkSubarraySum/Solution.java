package s523_checkSubarraySum;

import org.junit.Test;

import java.util.HashMap;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % k == 0) {
                return true;
            }
            for (int j = 0; j < i - 1; j++) {
                if ((nums[i] - nums[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
