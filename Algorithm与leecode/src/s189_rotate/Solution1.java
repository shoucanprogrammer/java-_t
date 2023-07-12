package s189_rotate;

public class Solution1 {
    public void rotate(int[] nums, int k){
        int len = nums.length;
        int[] newNums = new int[len];
        for (int i = 0; i < len; i++){
            newNums[(i+k)%len] = nums[i];
        }
        System.arraycopy(newNums,0,nums,0,len);
    }
}
