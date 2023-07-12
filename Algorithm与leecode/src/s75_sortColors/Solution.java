package s75_sortColors;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        sortColors1(new int[]{1,0});
    }
    public void sortColors(int[] nums) {
        //冒泡排序
        int cur;
        for (int i = 0; i < nums.length ; i ++){
            for (int j = i;j < nums.length; j ++){
                if (nums[j] < nums[i]){
                    cur = nums[i];
                    nums[i] = nums[j];
                    nums[j] = cur;
                }
            }
        }
    }


    public void sortColors1(int[] nums) {
        //双指针
        int p0 = 0;
        int p1 = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                if (p1==p0){
                    cur = nums[p0];
                    nums[p0] = nums[i];
                    nums[i] = cur;
                    p0++;
                    p1++;
                }else if (p1>p0){
                    //p0互换
                    cur = nums[p0];
                    nums[p0] = nums[i];
                    nums[i] = cur;
                    p0++;
                    //p1互换
                    cur = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = cur;
                    p1++;
                }
            }else if (nums[i] == 1){
                cur = nums[p1];
                nums[p1] = nums[i];
                nums[i] = cur;
                p1++;
            }
        }
        }
}
