package s26_removeDuplicates;

import org.junit.Test;
public class Solution {
    @Test
    public void test(){
        int[] nums = new int[]{1,1,2};
        int i = removeDuplicates2(nums);
        System.out.println();

    }

    public int removeDuplicates(int[] nums) {
        int value = 0;
        int place = 0;
        for (place = 1; place < nums.length; place++ ){
            if (nums[place] != nums[value]){
                value++;
                nums[value] = nums[place];
            }
        }
    return value+1;
    }

    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }


}
