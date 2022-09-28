package s34_searchRange;

import org.junit.Test;
public class Solution {
    @Test
    public void test(){
        searchRange(new int[]{2,2},2);
    }
    public int[] searchRange(int[] nums,int target){
        int end = nums.length -1;
        int start = 0;
        int mid ;
        int[] err = new int[]{-1,-1};
        if (nums.length ==0)
            return err;
        if (nums[start]> target)
            return err;
        if (nums[end]<target)
            return err;
        while (start<=end){
            mid = (start + end) / 2;
            if (nums[mid] == target){
                start = startrange(nums,start,mid,target);
                end = endtrange(nums,mid,end,target);
                return new int[]{start,end};
            }
            if (nums[start] <= target && nums[mid] >= target){
                end = mid;
            }else if (nums[mid+1] <= target && nums[end] >= target){
                start = mid+1;
            }else {
                return err;
            }
        }
        return err;
    }
    public int startrange(int[] nums,int start, int end, int targer){
        while (start <= end){
            int mid = (start + end) / 2;
            if ((nums[mid] == targer && mid == 0)||(nums[mid] == targer && nums[mid - 1] != targer) ){
                return mid;
            }else if (nums[mid] != targer){
                start = mid+1;
            }else {
                end = mid -1;
            }

        }
        return -1;
    }
    public int endtrange(int[] nums,int start, int end, int targer){
        while (start <= end){
            int mid = (start + end) / 2;
            if ((nums[mid] == targer && mid + 1 == nums.length)||(nums[mid] == targer && nums[mid + 1] != targer)){
                return mid;
            }else if (nums[mid] != targer){
                end = mid -1;
            }else {
                start = mid + 1;
            }

        }
        return -1;
    }

}
