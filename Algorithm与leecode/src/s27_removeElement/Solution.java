package s27_removeElement;

import org.testng.annotations.Test;

public class Solution {
    @Test
    public void test(){
        int[] nums = new int[]{3,2,2,3};
        int i = removeElement(nums,3);
        System.out.println();

    }
    public int removeElement(int[] nums,int val){
        if (nums.length == 0)
            return 0;
        int value = 0;
        int place ;
        for (place = 0; place < nums.length; place++ ){
            if (nums[place] != val){
                nums[value] = nums[place];
                value++;

            }
        }
        return value;
    }


}
