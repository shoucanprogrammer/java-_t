package s179_myLargestNumber;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    @Test
    public void test(){
        largestNumber(new int[]{3,30,34,5,9});
    }
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }
//        Arrays.sort(nums,(x,y)->x-y);

        Arrays.sort(numsArr,(a,b)->b-a);
        Arrays.sort(numsArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                int n = s1.length();
                int m = s2.length();
                StringBuffer buffer1 = new StringBuffer();
                StringBuffer buffer2 = new StringBuffer();
                for (int i = 0; i < n; i++){
                    buffer1.append(s1.charAt(i));
                }
                for (int i = 0; i < m; i++){
                    buffer2.append(s2.charAt(i));
                }

                return buffer2.append(buffer1).toString().compareTo(buffer1.append(buffer2).toString());
            }
        });
        StringBuffer bf3 = new StringBuffer();
        if (numsArr[0] == 0){
            return new String("0");
        }
        for (int i = 0; i < numsArr.length; i++){
            bf3.append(numsArr[i]);
        }
        return bf3.toString();
    }
}
