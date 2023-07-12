package s80_removeDuplicates;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        removeDuplicates(new int[]{0,0,0});
    }
    public int removeDuplicates(int[] nums){
        int befor = nums[0];
        int counter = 1;
        int cur = 0;
        int num = nums.length;
        if (nums[0] == nums[num-1]){
            if (num >=2){
                return 2;
            }else {
                return num;
            }
        }
        for (int i = 1; i < nums.length; i++){
            if (befor == nums[i]){
                counter++;
            }else {
                counter = 1;
                befor = nums[i];
            }
            if (counter > 2){
                num--;
                counter--;
                for (int j = i;j<nums.length-1;j++){
                    nums[j] = nums[j+1];
                }
                nums[num] = nums[0];
                i--;
            }
            if (i>=2&&nums[i] == nums[0]){
                break;
            }
        }
        return num;
    }
}
