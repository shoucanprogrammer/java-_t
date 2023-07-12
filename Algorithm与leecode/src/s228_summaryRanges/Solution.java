package s228_summaryRanges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    @Test
    public void test(){
        summaryRanges(new int[]{-2147483648,-2147483647,2147483647});
    }
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0){
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<>();
        StringBuilder builder1 = new StringBuilder();
        builder1.append(nums[0]);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]+1 ){
                StringBuilder builder = new StringBuilder();
                builder.append(nums[i-1]);


                if (!builder1.toString().equals(builder.toString())  ){
                    builder1.append('-');
                    builder1.append('>');
                    builder1.append(nums[i-1]);
                }

                list.add(builder1.toString());
                builder1 = new StringBuilder();
                builder1.append(nums[i]);

            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(nums[nums.length-1]);
        if (!builder1.toString().equals(builder.toString())){
            builder1.append('-');
            builder1.append('>');
            builder1.append(nums[nums.length-1]);
        }
        list.add(builder1.toString());
        return list;
    }
}
