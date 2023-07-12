package s191_hammingWeight;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        hammingWeight(00000000000000000000000000001011);
    }
    public int hammingWeight(int n) {
        int ans = 0;
        while ( n!= 0){
            for (int i = 0; i < 32; i++) {
                if ((n & (1 << i)) != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
