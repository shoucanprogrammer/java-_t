package s283_moveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int labellast = nums.length;
        for (int i = nums.length - 1; i >= 0; i--){
            if (nums[i] == 0){
                //交换位置
                for (int j = i; j < labellast -1; j++){
                    nums[j] = nums[j + 1];
                }
                nums[labellast -1] = 0;
                labellast--;
            }


        }
    }
}
