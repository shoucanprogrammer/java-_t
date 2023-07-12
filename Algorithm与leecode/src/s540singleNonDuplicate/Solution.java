package s540singleNonDuplicate;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8});
    }
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int right = n-1;
        int left = 0;
        if (n == 1){
            return nums[0];
        }
        while (left < right){
            int mid = (right + left)/2;
            if (mid % 2 == 1){
                if (mid+1<n&&nums[mid] == nums[mid+1]){
                    right = mid -1;
                }else if (mid-1>0&&nums[mid] == nums[mid -1]){
                    left = mid + 1;
                }else {
                    return nums[mid];
                }
            }else {
                if (mid+1<n&&nums[mid] == nums[mid+1]){
                    left = mid + 1;

                }else if (mid-1>0&&nums[mid] == nums[mid -1]){
                    right = mid -1;
                }else {
                    return nums[mid];
                }
            }

        }
        return nums[right];
    }
}
