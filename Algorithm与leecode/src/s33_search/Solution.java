package s33_search;

import org.junit.Test;
public class Solution {

    @Test
    public void test(){
        int search = search(new int[]{5,1,3}, 5);
    }
    public int search(int[] nums , int target){
        int len = nums.length;
        int mid ;
        int start = 0;
        int end = len -1;
        if (len == 1){
            if (nums[0] == target)
                return 0;
            return -1;
        }
        while (start<=end){
            mid = (start + end) / 2;
            if (nums[mid] == target){
                return  mid;
            }
            //分为了两个部分 start-mid    mid+1 - end
            if (nums[mid] >= nums[start]&&nums[mid+1] > nums[end]){
                //有序左序列
                if(nums[start] <= target && nums[mid] >= target){
                    //可能在左序列中
                    end = mid;
                }else if (nums[mid+1] > nums[end]){
                    //无序右序列
                    start = mid + 1;
                }
            }else if (nums[mid+1] <= nums[end]&&nums[mid] < nums[start]){
                //有序右序列
                if(nums[mid+1] <= target && nums[end] >= target){
                    //可能在右序列中
                    start = mid + 1;
                }else if (nums[start] > nums[mid]){
                    //无序左序列
                    end = mid;
                }
            }else {
                //都是有序序列
                if(nums[start] <= target && nums[mid] >= target){
                    //可能在左序列中
                    end = mid;
                }else  if(nums[mid+1] <= target && nums[end] >= target){
                    //可能在右序列中
                    start = mid + 1;
                }else{
                    return -1;
                }
            }
        }
        return -1;
    }

}
