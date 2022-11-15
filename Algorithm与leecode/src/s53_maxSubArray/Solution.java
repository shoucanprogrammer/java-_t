package s53_maxSubArray;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        int maxSubArray = maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
    /**
     * 动态规划
     * @param nums
     * @return 最大子序和
     */
    public int maxSubArray(int[] nums) {
        int left = 0;
        int len = nums.length;
        int sum = 0;
        int ans = nums[0];
        for (int i = 0; i < len; i++){
            if (sum <= 0){
                sum = nums[i];
            }else {
                sum = sum + nums[i];
            }
            ans = Math.max(ans,sum);

        }
        return ans;
    }

    /**
     *分治
     */
    public int maxSubArray1(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    public Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    public Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }


}
