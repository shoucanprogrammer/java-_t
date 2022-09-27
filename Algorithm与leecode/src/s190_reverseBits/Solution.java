package s190_reverseBits;

import org.junit.jupiter.api.Test;

public class Solution {
    @Test
    public void test(){


    }
    public int reverseBits2(int n) {
        int n1 = 0;

        while (true){

            n1 = n1*10+n%10;
            n = n/10;
            if (n<1){
                break;
            }
        }
        return n1;
    }
    public int reverseBits(int n) {
        int result = 0;
        for (int k = 0; k < 32 && n != 0; k++) {
            result |= (n & 0x01) << (31 - k);
            n >>>= 1;
        }

        return result;
    }


}
