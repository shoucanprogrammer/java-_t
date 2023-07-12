package s66_plusOne;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        plusOne(new int[]{9,9,9});
    }
    public int[] plusOne(int[] digits){

        int len = digits.length;
        if (len ==0){
            return digits;
        }
        int num = 0;
        if (digits[len-1] != 9){
            digits[len-1]++;
            return digits;
        }
        for (int i = len-1; i >= 0; i--){
            if (digits[i]==9){
                num++;
            }else {
                break;
            }
        }
        //进位index
        int n = len - num -1;

        for (int i = n+1; i < len; i++){
            digits[i] = 0;
        }
        if (n >= 0){
            digits[n]++;
        }else {
            //补位数
            int[] newdigits = new int[len + 1];
            newdigits[0] = 1;
            return newdigits;
        }

        return digits;
    }
}
