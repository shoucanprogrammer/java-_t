package s35_searchInsert;

import org.testng.annotations.Test;

public class Solution {
    @Test
    public void test(){
        int i = searchInsert(new int[]{3,5,7,9,10}, 8);
        System.out.println();
    }
    public int searchInsert(int[] nums, int target) {
        int end = nums.length -1;
        int start = 0;
        int mid ;
        if (nums[start]> target)
            return start;
        if (nums[end]<target)
            return end+1;
        while (start<=end){
            mid = (start + end) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[start] <= target && nums[mid] >= target){
                end = mid;
            }else if (nums[mid+1] <= target && nums[end] >= target){
                start = mid+1;
            }else {
                return mid+1;
            }
        }
        return end;
    }
}
