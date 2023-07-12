package s795_numSubarrayBoundEdMax;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        numSubarrayBoundedMax(new int[]{2,9,2,5,6,7,7},2,8);
    }
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}

