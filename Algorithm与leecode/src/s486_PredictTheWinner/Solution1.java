package s486_PredictTheWinner;

public class Solution1 {
    public boolean PredictTheWinner(int[] nums) {
        int dfs = dfs(nums, 0, nums.length - 1);
        return dfs >= 0 ? true:false;
    }

    public int dfs(int[] nums, int start, int end){
        if (start == end){
            return nums[start];
        }
        int startSum = nums[start] - dfs(nums,start+1,end);
        int endSum = nums[end] - dfs(nums,start,end-1);
        return Math.max(startSum,endSum);
    }

}
