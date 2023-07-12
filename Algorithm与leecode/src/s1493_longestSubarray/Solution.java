package s1493_longestSubarray;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        longestSubarray(new int[]{1,1,0,1,0});
    }
    public int longestSubarray(int[] nums) {
        int l = 0;
        int num = 0;//记录0出现的次数
        int max = 0;
        int zoreLable1 = 0 ;
        int zoreLable2 = 0 ;//记录0出现的坐标
        int r = 0;
        for (r = 0; r < nums.length; r++){
            int cur ;
            if (nums[r] == 0&&num==0){
                num++;
                zoreLable1 = r;
            }else if (nums[r] == 0&&num==1){
                num++;
                zoreLable2 = r;
            }
            if (num == 2){
                max = Math.max(max,r-l-1);
                l = zoreLable1+1;
                zoreLable1 = zoreLable2;
                num --;
            }
        }
        if (zoreLable2<=r-1&&zoreLable2>=l){
            max = Math.max(max,r-l-1);
        }else if (zoreLable2<l){
            max = Math.max(max,r-l);
        }
    return max;
    }
}
