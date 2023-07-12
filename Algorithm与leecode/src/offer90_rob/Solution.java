package offer90_rob;

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int fist = nums[0], second = Math.max(nums[1],fist);
        for (int i = 2; i <= n - 2; i++ ){
            int tem = second;
            second = Math.max(second,fist+nums[i]);
            fist = tem;
        }
        int fist1 = nums[1], second1 = Math.max(nums[2],fist1);
        for (int i = 3; i <= n -1; i++ ){
            int tem = second1;
            second1 = Math.max(second1,fist1+nums[i]);
            fist1 = tem;
        }
        return Math.max(second,second1);
    }
}
