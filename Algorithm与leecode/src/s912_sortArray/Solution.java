package s912_sortArray;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        sortArray(new int[]{5,1,1,2,0,0});
    }
    public int[] sortArray(int[] nums) {
        quickSort(nums,0, nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int start, int end){
        int mid = (start + end) / 2;
        int l = start;
        int r = end;
        int midValue = nums[mid];
        while (r > l){
            while (nums[l] < midValue ){
                l++;
            }
            while (nums[r] > midValue ){
                r--;
            }
            if (l >= r){
                break;
            }
            //交换
            int tem = nums[r];
            nums[r] = nums[l];
            nums[l] = tem;
            if (nums[r] == midValue ){
                l++;
            }
            if (nums[l] == midValue ){
                r--;
            }
        }
        //交换完成
        if (l == r){
            l = l + 1;
            r = r -1;
        }
        if (r > start){
            quickSort(nums,start,r);
        }
        if ( l < end){
            quickSort(nums,l,end);
        }
    }

}
