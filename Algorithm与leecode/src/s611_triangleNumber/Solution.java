package s611_triangleNumber;

import org.junit.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        triangleNumber(new int[]{4,2,3,4});
    }

    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int k = i;

            for (int j = i + 1; j < n; ++j) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {  //等腰三角形
                    ++k;
                }
                ans += Math.max(k - j, 0);
            }
        }
//        return ans;
        return ans;
    }
}
