package s494_findTargetSumWays;

public class Solution {
    int count = 0;
    int len ;
    public int findTargetSumWays(int[] nums, int target) {
        len = nums.length;
        trackBack(nums,0,-1,target);
        return count;
    }

        public void trackBack(int[] nums,int sum,int i,int target){
            if (i ==  len ){
                if (sum == target){
                    count++;
                }
                return;
            }
            trackBack(nums,sum+nums[i],i+1,target);
            trackBack(nums,sum-nums[i],i+1,target);
    }

}
