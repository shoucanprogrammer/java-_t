package s2134_minSwaps;

import org.junit.Test;

/*
@可爱抱抱
执行用时：3 ms, 在所有 Java 提交中击败了99.59%的用户
内存消耗：48.4 MB, 在所有 Java 提交中击败了72.23%的用户
2022年1月11日 15:22
*/
public class Solution {
    @Test
    public void test(){
        minSwaps(new int[]{0,1,0,1,1,0,0});
    }
    public int minSwaps(int[] nums) {
        int count=0,ans=0,num=0;//分别用来记录数组内1总数、滑窗内1最大数、以及现在滑窗内1个数
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
        }
        //此时确定滑窗大小为count
        for(int i=0;i<count;i++){
            num+=nums[i];
        }
        ans=num;
        for(int i=0;i<nums.length-1;i++){
            num+=nums[(count+i)%nums.length]-nums[i];
            ans=Math.max(ans,num);
        }
        return count-ans;
    }
}
