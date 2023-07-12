package LCS_02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    @Test
    public void test(){
        halfQuestions(new int[]{1,10,11,11,8,4});
    }
    public int halfQuestions(int[] questions) {
        int n = questions.length;
        int[] count = new int[1001];
        for (int i =0; i < n; i++){
            count[questions[i]]++;
        }
        //找最大频率的数
        Arrays.sort(count);
        int num = 0;
        int t= 0;
        int k = 0;
        for (int i = 1000; i>0 ; i--){
            if ( num >= (n+1)/2){
                return k;
            }
            num += count[i];
            k++;
        }
        return k;
    }
}
