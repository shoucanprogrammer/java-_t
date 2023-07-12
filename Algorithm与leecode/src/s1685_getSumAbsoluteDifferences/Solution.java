package s1685_getSumAbsoluteDifferences;


public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++){  //获取前缀和
            preSum[i] = preSum[i-1] + nums[i];
        }
        int[] out = new int[n];
        out[n-1] = n* nums[n-1] - preSum[n-1];
        out[0] =  preSum[n-1]-n * nums[0];
        for (int i = 1; i < n-1; i++){
            out[i] = (i+1)*nums[i]-preSum[i] + preSum[n-1]-preSum[i]-(n-1-i)*nums[i] ;
        }
        return out;
    }
}

