package s81_search;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        search1(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13);
    }

    public boolean search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return false;
        }
        if (len==1){
            return nums[0] == target;
        }
        int l = 0, r = len -1;
        while (l <= r){
            int mid = (l + r) /2;
            if (nums[mid] == target){
                return true;
            }
            if (r==l){
                break;
            }
            if (nums[mid]==nums[l]&&nums[mid] == nums[r]){
                l++;
                r--;
            }
            //判断左连续性？
            else if (nums[l] <= nums[mid]){
                //左连续
                if (target < nums[mid]&&nums[l] <= target){
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }else {
                if (target > nums[mid] && target <= nums[r]){
                    l = mid+1;
                }else {
                    r = mid-1;
                }
            }


        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;

            } else if (nums[l] <= nums[mid]) {//判断是否连续
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
