package s231_isPowerOfTwo;

import org.junit.Test;

public class Solution {
    @Test
    public void test(){
        isPowerOfTwo(3);
    }
    public boolean isPowerOfTwo(int n) {
        return n>=0 ? f(n) : false;
    }

    private boolean f(int n) {
        if (n==1)
            return true;
        if (n%2!=0 || n==0)
            return false;
        return f(n/2);
    }
}