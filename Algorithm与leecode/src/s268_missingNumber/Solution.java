package s268_missingNumber;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    @Test
    public void test(){
        missingNumber(new int[]{0,2,3});
    }
    private int getNumber;
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length-1] != nums.length){
            return nums.length;
        }
        erfen(nums,0,nums.length-1);
        return getNumber;
    }
    public void erfen(int[] nums,int start,int end){
        int mid = (start+end)/2;
        if (start == end){
            getNumber = end;
            return;
        }
        if (start>end){
            getNumber = nums.length;
            return ;
        }
        if (nums[mid] == mid){
            erfen(nums,mid+1,end);
            return;
        }
//        if (nums[mid] <mid){
//            erfen(nums,start,mid);
//            return;
//        }
        if (nums[mid] > mid){
            erfen(nums,start,mid);
            return;
        }
    }
}
