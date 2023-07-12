package s704_search;

public class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
       if (nums[0] == target){
           return 0;
       }
        while (left <= right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] > target){
                right = mid -1;
            }else if (nums[mid] < target){
                    left = mid + 1;
                }

        }
        return -1;
    }
}
