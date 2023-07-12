package s372_superPow;

import org.junit.jupiter.api.Test;

import java.util.Map;

public class Solution {
    @Test
    public void test(){
        superPow(2,new int[]{4,2});
    }
    public int superPow(int a,int[] b){
        int k = 0;
        for (int i = 0; i < b.length; i++){
            k *= 10;
            k += b[i];
        }
        int ans = a;
        for (int i = 1; i < k; i++){
            ans = ((ans %1337)* (a%1337))%1337;
        }
        return ans;
    }
}
