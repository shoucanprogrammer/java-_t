package s41_firstMissingPositive;


import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));
    }
    public int firstMissingPositive(int[] nums) {
        int tem;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            while (nums[i]>0 && nums[i] <= len){
                if (nums[i]>len||nums[i]<=0||nums[i]==nums[nums[i]-1])
                    break;
                if (nums[i] <= len){
                    tem = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = tem;
                }
            }
        }
        for (int j = 0; j < len; j++){
            if (nums[j] !=j+1)
                return j+1;
        }
        return len+1;
    }


    public int firstMissingPositive1(int[] nums) {
        int tem;
        int len = nums.length;
        for (int i = 0; i < len; i++){
            while (nums[i]>0 && nums[i] <= len){
                if (nums[i]>len||nums[i]<=0||nums[i]==nums[nums[i]-1])
                    break;
                if (nums[i] < len){
                    tem = nums[nums[i]-1];
                    nums[nums[i]-1] = nums[i];
                    nums[i] = tem;
                }
            }
        }
        for (int j = 0; j < len; j++){
            if (nums[j] !=j+1)
                return j+1;
        }
        return len+1;
    }
}
